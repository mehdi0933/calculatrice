package org.example;

import org.example.Calculator.Calculator;
import org.example.calculeInterface.Calcule;
import org.example.calculeStrategy.Addition;
import org.example.calculeStrategy.Division;
import org.example.calculeStrategy.Multiplication;
import org.example.calculeStrategy.Soustration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Operateur (+, -, *, /) : ");
        String operator = scanner.next();


        Calculator calculator;
        switch (operator) {
            case "+":
                calculator = Calculator.getInstance(new Addition());
                break;
            case "-":
                calculator = Calculator.getInstance(new Soustration());
                break;
            case "*":
                calculator = Calculator.getInstance(new Multiplication());
                break;
            case "/":
                calculator = Calculator.getInstance(new Division());
                break;
            default:
                System.out.println("les Operateur valide (+, -, *, /)");
                return;
        }

        List<Integer> numbers = new ArrayList<>();

        System.out.println("Entrez des nombres et tapez '=' pour terminer :");

        while (true) {
            String input = scanner.next();

            if (input.equalsIgnoreCase("=")) {
                break;
            }

            int addNomber = Integer.parseInt(input);
            numbers.add(addNomber);
        }

        int[] nmbCaculeArrey = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            nmbCaculeArrey[i] = numbers.get(i);
        }
        int result = calculator.calculatorOperation(nmbCaculeArrey);
        System.out.println("Résultat : " + result);
    }
}
