package org.example.enumeration;

public enum TypeCalcule {

    MULTIPLICATION("*"),
    DIVISION("/"),
    ADDITION("+"),
    SOUSTRACTION("-");

    private final String symbol;

    TypeCalcule(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
      }

    public static TypeCalcule fromSymbol(String symbol) {
        for (TypeCalcule op : values()) {
            if (op.symbol.equals(symbol)) return op;
        }
        throw new IllegalArgumentException("Symbole inconnu : " + symbol);
    }
}
