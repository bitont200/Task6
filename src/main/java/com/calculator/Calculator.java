package com.calculator;

public class Calculator {

    public int calculate(String expression) {
        // Handle addition
        if (expression.contains("+")) {
            String[] numbers = expression.split("\\+");
            int result = 0;
            for (String num : numbers) {
                result += Integer.parseInt(num);
            }
            return result;
        }

        // Handle subtraction
        if (expression.contains("-")) {
            String[] numbers = expression.split("-");
            int result = Integer.parseInt(numbers[0]);
            for (int i = 1; i < numbers.length; i++) {
                result -= Integer.parseInt(numbers[i]);
            }
            return result;
        }

        // Single number
        return Integer.parseInt(expression);
    }
}