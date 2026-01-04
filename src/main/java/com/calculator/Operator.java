package com.calculator;

public interface Operator {
    int getPrecedence();
    int apply(int left, int right);
    char getSymbol();
}
