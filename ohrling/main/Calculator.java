package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final String REGEX = "(?<=[-+*/%()])|(?=[-+*/%()])";
    private Double sum = null;
    private char term = '!';
    private String[] prioritizedTerms = new String[] {"*", "/", "%", "(", ")"};

    public String calculateExpression(String expression) {
        if(expression.equals("Infinity")) {
            throw new RuntimeException("För stort värde!");
        }
        expression = expression.replace(',', '.');
        List<String> splitted = new ArrayList<>(Arrays.asList(expression.split(REGEX)));
        if (splitted.get(0).equals("+") || splitted.get(0).equals("-") || splitted.get(0).equals("*") || splitted.get(0).equals("/") || splitted.get(0).equals("%"))
            throw new NumberFormatException("Felaktigt värde");
        if((splitted.size() > 3) &&(expression.contains("*") || expression.contains("/") || expression.contains("%") || (expression.contains("(") && expression.contains(")")))) {
            splitted = calculatePrioritizedExpressions(splitted);
        }

        sum = executeExpression(splitted);

        if(sum.toString().length() > 9) {
            String shortenedSum = String.format("%.8f", sum);
            shortenedSum = shortenedSum.replace(',', '.');
            shortenedSum = removeZeros(Double.parseDouble(shortenedSum));
            return shortenedSum;
        } else{
            return sum.toString();
        }
    }

    private Double executeExpression(List<String> splitted) {
        sum = null;
        Double d2 = null;
        for (int i = 0; i < splitted.size(); i++) {
            if (splitted.get(i).equals("-") && splitted.get(i + 1).equals("-")) {
                splitted.set(i, "+");
                splitted.remove(i + 1);
            }
            if (checkString(splitted.get(i))) {
                if (sum == null) {
                    sum = Double.parseDouble(splitted.get(i));
                } else if (d2 == null) {
                    d2 = Double.parseDouble(splitted.get(i));
                }
            }
            if(sum != null && d2 != null && term != '!') {
                switch (term) {
                    case '+':
                        sum = addition(sum,d2);
                        break;
                    case '-':
                        sum = subtraction(sum,d2);
                        break;
                    case '*':
                        sum = multiplication(sum,d2);
                        break;
                    case '/':
                        sum = division(sum,d2);
                        break;
                    case '%':
                        sum = modulus(sum,d2);
                        break;
                }
                d2 = null;
                term = '!';
            }
        }
        return sum;
    }

    private List<String> calculatePrioritizedExpressions(List<String> splitted) {
        List<String> parenthesisExpression = new ArrayList<>();
        while (splitted.size() > 3) {
            Integer prioPosition = null;
            String tempSum = null;
            Integer parenthesisStartPosition = null;
            Integer parenthesisEndPosition = null;

            while(splitted.contains("(")) {
                parenthesisStartPosition = splitted.indexOf("(");
                parenthesisEndPosition = splitted.indexOf(")");

                if(parenthesisStartPosition != 0 && checkString(splitted.get(parenthesisStartPosition - 1))) {
                    splitted.add(parenthesisStartPosition, "*");
                    parenthesisStartPosition += 1;
                    parenthesisEndPosition += 1;
                } else if(parenthesisStartPosition == 0) {
                    for (int i = parenthesisStartPosition + 1; i < splitted.size(); i++) {
                        if(splitted.get(i).equals("(")) {
                            splitted.add(i, "*");
                            i++;
                        }
                    }
                }
                term = '!';

                parenthesisExpression.addAll(splitted.subList(parenthesisStartPosition + 1,parenthesisEndPosition));
                String parenthesisSum = executeExpression(parenthesisExpression).toString();
                splitted.set(parenthesisStartPosition, parenthesisSum);
                splitted.subList(parenthesisStartPosition + 1, parenthesisEndPosition + 1).clear();
                parenthesisExpression.clear();
            }
            for (String tempTerm :
                    prioritizedTerms) {
             if(splitted.contains(tempTerm)) {
                    if (prioPosition == null)
                        prioPosition = splitted.indexOf(tempTerm);
                    else if (prioPosition > splitted.indexOf(tempTerm) && splitted.indexOf(tempTerm) != -1 || prioPosition == -1)
                        prioPosition = splitted.indexOf(tempTerm);
                }
            }
            if(prioPosition != null){
                if(checkString(splitted.get(prioPosition -1)) && checkString(splitted.get(prioPosition +1))) {
                    tempSum = calculateExpression(splitted.get(prioPosition - 1) + splitted.get(prioPosition) +  splitted.get(prioPosition + 1));
                    splitted.remove(prioPosition + 1);
                }
                if (!checkString(splitted.get(prioPosition))) {
                    splitted.remove(prioPosition.intValue());
                    term = '!';
                } else if (!splitted.get(prioPosition - 1).equalsIgnoreCase("+") || splitted.get(prioPosition + 1).equalsIgnoreCase("+"))
                    splitted.set(prioPosition, "+");
                splitted.set(prioPosition - 1, tempSum.toString());
            } else {
                break;
            }
        }
        term = '!';
        return splitted;
    }

    public double addition(double d1, double d2) {
        return d1 + d2;
    }

    public double subtraction(double d1, double d2) {
        return d1-d2;
    }

    public double multiplication(double d1, double d2) {
        return d1*d2;
    }

    public double division(double d1, double d2) {
        if(d2 != 0) {
            return d1 / d2;
        } else {
            throw new ArithmeticException("Kan inte dividera med 0");
        }
    }

    public double modulus(double d1, double d2) {
        return d1%d2;
    }

    public boolean checkString(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            if(s.equals("-") || s.equals("+") || s.equals("*") || s.equals("/") || s.equals("%")) {
                if(term == '!' || term != s.charAt(0)) {
                    term = s.charAt(0);
                    return false;
                } else {
                    throw new NumberFormatException("Felaktigt värde");
                }
            } else if(s.equals("(") || s.equals(")")) {
                return false;
            } else {
                throw new NumberFormatException("Felaktigt värde");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Felaktigt värde");
        }
        return true;
    }

    private static String removeZeros(double d) {
        return String.valueOf(d).replaceAll("[0]*$", "").replaceAll("\\.$", "");
    }
}
