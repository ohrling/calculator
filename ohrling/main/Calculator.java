package main;

public class Calculator {
    public String calculateExpression(String s) {
        Double sum = 0.0;
        String[] splitted;
        if(s.contains("+")) {
            splitted = s.split("([+])");
            for (String num :
                    splitted) {
                if(!num.equalsIgnoreCase("+")) {
                    sum = addition(sum, convertStringToDouble(num));
                }
            }
        } else if(s.contains("-")) {
            splitted = s.split("([-])");
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
         }else if(s.contains("*")) {
            splitted = s.split("([*])");
            for(int i = 0; i < splitted.length; i++) {
                if(!splitted[i].equalsIgnoreCase("*")){
                    if(i == 0) {
                        sum = convertStringToDouble(splitted[i]);
                    } else {
                        sum = multiplication(sum, convertStringToDouble(splitted[i]));
                    }
                }
            }
        }  else {
            sum = convertStringToDouble(s);
        }
        return sum.toString();
    }

    public double addition(double d1, double d2) {
        return d1 + d2;
    }

    public double subtraction(double d1, double d2) {
        return d1-d2;
    }

    public Double convertStringToDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public double multiplication(double d1, double d2) {
        return d1*d2;
    }
}
