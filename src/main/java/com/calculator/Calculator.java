package com.calculator;

public class Calculator {
    private final ExpressionParser parser;
    private final ExpressionEvaluator evaluator;

    public Calculator() {
        this.parser = new ExpressionParser();
        this.evaluator = new ExpressionEvaluator(parser);
    }

    public int calculate(String expression) {
        // Remove all whitespace
        expression = expression.replaceAll("\\s+", "");

        // Validate expression
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty");
        }

        // Parse and evaluate
        var tokens = parser.parse(expression);
        return evaluator.evaluate(tokens);
    }
}