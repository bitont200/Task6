package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should add two single digit numbers")
    void testSimpleAddition() {
        String expression = "1+2";

        int result = calculator.calculate(expression);

        assertEquals(3, result, "1+2 should equal 3");
    }
}