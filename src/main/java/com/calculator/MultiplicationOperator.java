package com.calculator;

public class MultiplicationOperator implements Operator {
    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public int apply(int left, int right) {
        return left * right;
    }

    @Override
    public char getSymbol() {
        return '*';
    }
}