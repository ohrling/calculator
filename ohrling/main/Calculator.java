package main;

public class Calculator {
    public String calculateExpression(String s) {
        String[] splitted = s.split("([+])");
        Double sum = addition(convertStringToDouble(splitted[0]), convertStringToDouble(splitted[1]));
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
