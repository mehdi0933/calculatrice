package service;


import org.example.enumeration.TypeCalcule;
import org.example.factory.Operation;

import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {

    public int evaluate(List<String> tokens) {

        Stack<Integer> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {


            if (token.matches("\\d+")) {
                numbers.push(Integer.parseInt(token));
            }
            else if (token.equals("(")) {
                operators.push(token);
            }
            else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    compute(numbers, operators);
                }
                operators.pop();
            }
            else if (token.matches("[+\\-*/]")) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    compute(numbers, operators);
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            compute(numbers, operators);
        }

        return numbers.pop();
    }

    private void compute(Stack<Integer> numbers, Stack<String> operators) {
        int rightOperand = numbers.pop();
        int leftOperand = numbers.pop();
        TypeCalcule typeCalcule = TypeCalcule.fromSymbol(operators.pop());
        numbers.push(Operation.getCalculator(typeCalcule).calculatorOperation(leftOperand, rightOperand));
    }

    private int precedence(String op) {
        return (op.equals("*") || op.equals("/")) ? 2 : 1;
    }
}
