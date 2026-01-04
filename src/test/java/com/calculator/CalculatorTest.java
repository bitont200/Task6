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

    @Test
    @DisplayName("Should add multiple single digit numbers")
    void testMultipleAddition() {
        assertEquals(6, calculator.calculate("1+2+3"));
    }

    @Test
    @DisplayName("Should add numbers with multiple digits")
    void testAdditionWithLargeNumbers() {
        assertEquals(579, calculator.calculate("123+456"));
    }
}