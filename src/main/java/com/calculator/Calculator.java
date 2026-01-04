package com.calculator;

public class Calculator {

    public int calculate(String expression) {
        String[] numbers = expression.split("\\+");
        int result = 0;

        for (String num : numbers) {
            result += Integer.parseInt(num);
        }

        return result;
    }
}