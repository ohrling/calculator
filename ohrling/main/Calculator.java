package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public String calculateExpression(String expression) {
        Double sum;
        String regex = "(?<=[-+*/%()])|(?=[-+*/%()])";
        List<String> splitted = new ArrayList<>(Arrays.asList(expression.split(regex)));
        if(expression.contains("*") || expression.contains("/") || expression.contains("%") || (expression.contains("(") && expression.contains(")"))) {
            splitted = calculatePrioritizedExpressions(splitted);
        }
        sum = executeExpression(splitted);
        return sum.toString();
    }

    private Double executeExpression(List<String> splitted) {
        Double sum = null;
        Double d2 = null;
        char term = '!';
        for (int i = 0; i < splitted.size(); i++) {
            if(sum == null)
                sum = convertStringToDouble(splitted.get(i));
            else if(d2 == null)
                d2 = convertStringToDouble(splitted.get(i));
            if(sum == null || d2 == null)
                term = splitted.get(i).charAt(0);
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
            }
        }
        return sum;
    }

    private List<String> calculatePrioritizedExpressions(List<String> splitted) {
        String[] prioritizedTerms = new String[] {"*", "/", "%", "(", ")"};
        List<String> parenthesisExpression = new ArrayList<>();
        while (splitted.size() > 3) {
            Integer prioPosition = null;
            Double tempSum = null;
            Integer parenthesisStartPosition = null;
            Integer parenthesisEndPosition = null;

            if(splitted.contains("(")) {
                parenthesisStartPosition = splitted.indexOf("(");
                parenthesisEndPosition = splitted.indexOf(")");

                parenthesisExpression.addAll(splitted.subList(parenthesisStartPosition + 1,parenthesisEndPosition));
                StringBuilder generatedExpression = new StringBuilder();
                for (String s :
                        parenthesisExpression) {
                    generatedExpression.append(s);
                }
                String parenthesisSum = calculateExpression(generatedExpression.toString());
                splitted.set(parenthesisStartPosition, parenthesisSum);
                splitted.subList(parenthesisStartPosition + 1, parenthesisEndPosition + 1).clear();

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
                if (splitted.get(prioPosition).equalsIgnoreCase("*"))
                    tempSum = multiplication(convertStringToDouble(splitted.get(prioPosition - 1)), convertStringToDouble(splitted.get(prioPosition + 1)));
                else if (splitted.get(prioPosition).equalsIgnoreCase("/"))
                    tempSum = division(convertStringToDouble(splitted.get(prioPosition - 1)), convertStringToDouble(splitted.get(prioPosition + 1)));
                else if (splitted.get(prioPosition).equalsIgnoreCase("%"))
                    tempSum = modulus(convertStringToDouble(splitted.get(prioPosition - 1)), convertStringToDouble(splitted.get(prioPosition + 1)));
                splitted.remove(prioPosition + 1);

                if (convertStringToDouble(splitted.get(prioPosition)) == null)
                    splitted.remove(prioPosition.intValue());
                else if (!splitted.get(prioPosition - 1).equalsIgnoreCase("+") || splitted.get(prioPosition + 1).equalsIgnoreCase("+"))
                    splitted.set(prioPosition, "+");
                splitted.set(prioPosition - 1, tempSum.toString());
            }
        }
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
            throw new ArithmeticException();
        }
    }

    public double modulus(double d1, double d2) {
        return d1%d2;
    }


    public Double convertStringToDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
