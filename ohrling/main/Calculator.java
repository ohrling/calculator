package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public String calculateExpression(String expression) {
        Double sum = null;
        Double d2 = null;
        char term = '!';
        String[] prioritizedTerms = new String[] {"*", "/", "%"};
        String regex = "(?<=[-+*/%])|(?=[-+*/%])";
        List<String> splitted = new ArrayList<>(Arrays.asList(expression.split(regex)));
        if(splitted.contains("*") || splitted.contains("/") || splitted.contains("%")) {
            while (splitted.size() > 3) {
                Integer prioPosition = null;
                Double tempSum = null;
                for (String tempTerm :
                        prioritizedTerms) {
                    if (prioPosition == null)
                        prioPosition = splitted.indexOf(tempTerm);
                    else if(prioPosition > splitted.indexOf(tempTerm) && splitted.indexOf(tempTerm) != -1 || prioPosition == -1)
                        prioPosition = splitted.indexOf(tempTerm);
                }

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
        return sum.toString();
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
