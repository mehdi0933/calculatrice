package org.example.factory;

import org.example.calculator.Calculator;
import org.example.calculeStrategy.*;
import org.example.enumeration.TypeCalcule;


public class Operation {
    public static Calculator getCalculator(TypeCalcule typeCalcule) {
        return switch (typeCalcule) {
            case ADDITION -> Calculator.getInstance(new Addition());
            case SOUSTRACTION -> Calculator.getInstance(new Soustration());
            case MULTIPLICATION -> Calculator.getInstance(new Multiplication());
            case DIVISION -> Calculator.getInstance(new Division());
        };
    }
}
