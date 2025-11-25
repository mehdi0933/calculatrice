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
        List<Object> number = new ArrayList<>();

        System.out.println("laisser un espace entre chaque caractere  et tapez '=' pour terminer :");

        while (true) {
            String input = scanner.next();
            if (input.equals("=")) break;

            if (input.matches("\\d+")) {
                number.add(Integer.parseInt(input));
            } else if (input.matches("[+\\-*/]")) {
                number.add(input);
            } else {
                System.out.println("Entrée invalide : " + input);
            }
        }

        int result = (Integer) number.get(0);

        Calculator calculator = null;

        for (int i = 1; i < number.size(); i += 2) {
            String operator = (String) number.get(i);
            int nextNumber = (Integer) number.get(i + 1);

            switch (operator) {
                case "+": calculator = Calculator.getInstance(new Addition()); break;
                case "-": calculator = Calculator.getInstance(new Soustration()); break;
                case "*": calculator = Calculator.getInstance(new Multiplication()); break;
                case "/": calculator = Calculator.getInstance(new Division()); break;
            }

            result = calculator.calculatorOperation(result, nextNumber);
        }

        System.out.println("Résultat : " + result);

    }
}
