package com.calculator;

public class DivisionOperator implements Operator {
    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public int apply(int left, int right) {
        if (right == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left / right;
    }

    @Override
    public char getSymbol() {
        return '/';
    }
}