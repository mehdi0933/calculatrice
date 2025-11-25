import org.example.calculeInterface.Calcule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Object> numbers = new ArrayList<>();

        System.out.println("Entrez une expression (nombre opérateur nombre ...) et tapez '=' pour terminer :");

        while (true) {
            String input = scanner.next();

            if (input.equals("=")) {
                break;
            }

            // Vérifie si c'est un nombre ou un opérateur
            if (input.matches("\\d+")) {  // nombres entiers
                numbers.add(Integer.parseInt(input));
            } else if (input.matches("[+\\-*/]")) {  // opérateurs
                numbers.add(input);
            } else {
                System.out.println("Entrée invalide : " + input);
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            Object token = numbers.get(i);

            if (token instanceof String) {
                String op = (String) token;

                switch (op) {
                    case "+": System.out.println("Addition"); break;
                    case "-": System.out.println("Soustraction"); break;
                    case "*": System.out.println("Multiplication"); break;
                    case "/": System.out.println("Division"); break;
                }
            }
        }

    }
}
