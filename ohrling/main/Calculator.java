package main;

public class Calculator {
    public String calculateExpression(String s) {
        Double sum = 0.0;
        String[] splitted;
        if(s.contains("+")) {
            splitted = s.split("([+])");
            for (String num :
                    splitted) {
                if(num.equalsIgnoreCase("+")) {
                } else {
                    sum = addition(sum, convertStringToDouble(num));
                }
            }
        } else if(s.contains("-")) {
            splitted = s.split("([-])");
            sum = subraction(convertStringToDouble(splitted[0]), convertStringToDouble(splitted[1]));
        } else {
            sum = convertStringToDouble(s);
        }
        return sum.toString();
    }

    public double addition(double d1, double d2) {
        return d1 + d2;
    }

    public double subraction(double d1, double d2) {
        return d1-d2;
    }

    public Double convertStringToDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
