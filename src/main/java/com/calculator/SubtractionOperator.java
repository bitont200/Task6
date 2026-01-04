package com.calculator;

public class SubtractionOperator implements Operator {
    @Override
    public int getPrecedence() {
        return 1;
    }

    @Override
    public int apply(int left, int right) {
        return left - right;
    }

    @Override
    public char getSymbol() {
        return '-';
    }
}