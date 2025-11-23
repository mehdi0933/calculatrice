package org.example.Calculator;

import org.example.calculeInterface.Calcule;

public class Calculator {

    private static Calculator instance;
    private final Calcule calcule;

    private Calculator(Calcule calcule) {
        this.calcule = calcule;
    }

    public static Calculator getCalculator(Calcule calcule) {
        if (instance == null) {
            instance = new Calculator(calcule);
        }
        return instance;
    }

    public int calculatorOperation(int... args) {
        return calcule.calcule(args);
    }
}
