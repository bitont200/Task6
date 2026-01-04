package com.calculator;

public class Calculator {

    public int calculate(String expression) {
        // Implementation for simple addition only
        String[] parts = expression.split("\\+");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        return num1 + num2;
    }
}