package service;

public class ExpressionValidator {

    public boolean isValid(String expression) {
        // Vérifie que l'expression ne contient que des chiffres, des opérateurs (+, -, *, /), des parenthèses et le signe égal`
        return expression.matches("^[0-9+\\-*/()=]+$");
    }
}
