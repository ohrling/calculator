package main;

public class Calculator {
    public String calculateExpression(String expression) {
        Double sum = null;
        Double d1 = null;
        Double d2 = null;
        char term = '!';
        String regex = "(?<=[-+*/])|(?=[-+*/])";
        String[] splitted = expression.split(regex);
        for (int i = 0; i < splitted.length; i++) {
            if(d1 == null)
                d1 = convertStringToDouble(splitted[i]);
            else if(d2 == null)
                d2 = convertStringToDouble(splitted[i]);
            if(d1 == null || d2 == null)
                term = splitted[i].charAt(0);
            if(d1 != null && d2 != null && term != '!') {
                switch (term) {
                    case '+':
                        sum = addition(d1,d2);
                        break;
                    case '-':
                        sum = subtraction(d1,d2);
                        break;
                    case '*':
                        sum = multiplication(d1,d2);
                        break;
                    case '/':
                        sum = division(d1,d1);
                        break;
                    case '%':
                        sum = modulus(d1,d2);
                        break;
                }
                d1 = null;
                d2 = null;
            }
        }/*
        if(expression.contains("+")) {
            splitted = expression.split("([+ -])");
            for (String num :
                    splitted) {
                if(!num.equalsIgnoreCase("+") || !num.equalsIgnoreCase("-")) {
                    sum = addition(sum, convertStringToDouble(num));
                }
            }
        } else if(expression.contains("-")) {
            splitted = expression.split("([-])");
            for (String num :
                    splitted) {
                if(!num.equalsIgnoreCase("-")) {
                    if (sum == 0.0) {
                        sum = convertStringToDouble(num);
                    } else {
                        sum = subtraction(sum, convertStringToDouble(num));
                    }
                }
            }
         }else if(expression.contains("*")) {
            splitted = expression.split("([*])");
            for(int i = 0; i < splitted.length; i++) {
                if(!splitted[i].equalsIgnoreCase("*")){
                    if(i == 0) {
                        sum = convertStringToDouble(splitted[i]);
                    } else {
                        sum = multiplication(sum, convertStringToDouble(splitted[i]));
                    }
                }
            }
        } else if(expression.contains("/")) {
            splitted = expression.split("([/])");
            for(int i = 0; i < splitted.length; i++){
                if(!splitted[i].equalsIgnoreCase("/")) {
                    if(i == 0) {
                        sum = convertStringToDouble(splitted[i]);
                    } else {
                        sum = division(sum, convertStringToDouble(splitted[i]));
                    }
                }
            }
        } else if(expression.contains("%")) {
            splitted = expression.split("([%])");
            for(int i = 0; i < splitted.length; i++){
                if(!splitted[i].equalsIgnoreCase("/")) {
                    if(i == 0) {
                        sum = convertStringToDouble(splitted[i]);
                    } else {
                        sum = modulus(sum, convertStringToDouble(splitted[i]));
                    }
                }
            }
        } else {
            sum = convertStringToDouble(expression);
        }*/
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
