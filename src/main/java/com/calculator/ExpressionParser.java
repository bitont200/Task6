package com.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionParser {
    private final Map<Character, Operator> operators;

    public ExpressionParser() {
        operators = new HashMap<>();
        operators.put('+', new AdditionOperator());
        operators.put('-', new SubtractionOperator());
        operators.put('*', new MultiplicationOperator());
        operators.put('/', new DivisionOperator());
    }

    public List<Token> parse(String expression) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                numberBuffer.append(ch);
            } else if (operators.containsKey(ch)) {
                if (numberBuffer.length() > 0) {
                    tokens.add(new Token(TokenType.NUMBER, numberBuffer.toString()));
                    numberBuffer.setLength(0);
                }
                tokens.add(new Token(TokenType.OPERATOR, String.valueOf(ch)));
            }
        }

        if (numberBuffer.length() > 0) {
            tokens.add(new Token(TokenType.NUMBER, numberBuffer.toString()));
        }

        return tokens;
    }

    public Operator getOperator(char symbol) {
        return operators.get(symbol);
    }
}