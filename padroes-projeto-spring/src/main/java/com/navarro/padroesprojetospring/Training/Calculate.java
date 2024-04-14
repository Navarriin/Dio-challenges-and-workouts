package com.navarro.padroesprojetospring.Training;

import java.util.Scanner;

public class Calculate {

    public static void main(String[] args) {

        System.out.println("Resultado: " + leituraTeclado());
        System.out.println("---------//---------");

    }

    public static double leituraTeclado() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o primeiro numero: ");
        int numberOne = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o segundo numero: ");
        int lastNumber = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite a operação: ");
        String operation = scan.nextLine();
        scan.close();

        return calcular(numberOne, lastNumber, operation);
    }

    public static double calcular(double num1, double num2, String operation) {
       try {
           return switch (operation) {
               case "+" -> num1 + num2;
               case "*" -> num1 * num2;
               case "-" -> num1 - num2;
               case "/" -> num1 / num2;
               default -> 0;
           };
       } catch (ArithmeticException exception) {
            return 0;
       }
    }
}
