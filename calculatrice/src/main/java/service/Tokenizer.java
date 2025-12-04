package service;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    public List<String> tokenize(String expression) {
        // Sépare l'expression en tokens en gardant les opérateurs et parenthèses comme éléments distincts
        return Arrays.asList(expression.split("(?<=[-+*/=()])|(?=[-+*/=()])"));
    }
}
