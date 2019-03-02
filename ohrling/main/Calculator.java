package main;

public class Calculator {
    public String calculateExpression(String s) {
        Double sum;
        if(s.contains("+")) {
            String[] splitted = s.split("([+])");
            sum = addition(convertStringToDouble(splitted[0]), convertStringToDouble(splitted[1]));
        } else {
            sum = convertStringToDouble(s);
        }
        return sum.toString();
    }

    public double addition(double d1, double d2) {
        return d1 + d2;
    }

    public double subraction(double d1, double d2) {
        return 0;
    }

    public Double convertStringToDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
