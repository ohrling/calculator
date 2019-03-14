package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv in tal som du vill ha uträknat, vill du avsluta skriv \"exit\":");
        String calculation = "";
        while (!calculation.equals("exit")) {
            calculation = sc.nextLine();
            if(!calculation.equals("exit")) {
                try {
                    System.out.println(calc.calculateExpression(calculation));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        sc.close();
        System.out.println("Tack för denna gång!");
    }
}
