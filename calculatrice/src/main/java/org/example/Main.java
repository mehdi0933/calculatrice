package org.example;

import service.ExpressionValidator;
import service.Tokenizer;
import service.ExpressionEvaluator;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ExpressionValidator validator = new ExpressionValidator();
        Tokenizer tokenizer = new Tokenizer();
        ExpressionEvaluator evaluator = new ExpressionEvaluator();

        System.out.println("Entrez votre calcul et terminez par taper entre : ");
        String input = scanner.nextLine().replaceAll("\\s+", "");

        if (!validator.isValid(input)) {
            System.out.println("Expression invalide : uniquement chiffres et + - * / ( ) =");
            return;
        }

        List<String> tokens = tokenizer.tokenize(input);
        int result = evaluator.evaluate(tokens);

        System.out.println("Résultat : " + result);
    }
}
