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

    @Test
    @DisplayName("Should subtract two numbers")
    void testSimpleSubtraction() {
        assertEquals(3, calculator.calculate("5-2"));
    }

    @Test
    @DisplayName("Should handle negative results")
    void testSubtractionWithNegativeResult() {
        assertEquals(-5, calculator.calculate("10-15"));
    }

    @Test
    @DisplayName("Should subtract multiple single digit numbers")
    void testMultipleSubtraction() {
        assertEquals(2, calculator.calculate("5-2-1"));
    }

    @Test
    @DisplayName("Should subtract numbers with multiple digits")
    void testSubtractionWithLargeNumbers() {
        assertEquals(15, calculator.calculate("115-100"));
    }


}