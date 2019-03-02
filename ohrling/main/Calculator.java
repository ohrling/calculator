package main;

public class Calculator {
    public String calculateExpression(String s) {
        String[] splitted = s.split("([+])");
        Double sum = null;//addition((double)splitted[0], (double)splitted[1].charAt(0));
        return sum.toString();
    }

    public double addition(double d1, double d2) {
        return d1 + d2;
    }

    public double subraction(double d1, double d2) {
        return 0;
    }

    public Double convertStringToDouble(String s) {
        return Double.parseDouble(s);
    }
}
