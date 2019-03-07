package main;

public class Calculator {
    public String calculateExpression(String expression) {
        Double sum = null;
        Double d2 = null;
        char term = '!';
        String regex = "(?<=[-+*/%])|(?=[-+*/%])";
        String[] splitted = expression.split(regex);
        for (int i = 0; i < splitted.length; i++) {
            if(sum == null)
                sum = convertStringToDouble(splitted[i]);
            else if(d2 == null)
                d2 = convertStringToDouble(splitted[i]);
            if(sum == null || d2 == null)
                term = splitted[i].charAt(0);
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
