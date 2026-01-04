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

    @Test
    @DisplayName("Should multiply two numbers")
    void testSimpleMultiplication() {
        assertEquals(6, calculator.calculate("2*3"));
    }

    @Test
    @DisplayName("Should multiply multiple numbers")
    void testMultipleMultiplication() {
        assertEquals(24, calculator.calculate("2*3*4"));
    }

    @Test
    @DisplayName("Should handle multiplication with zero")
    void testMultiplicationWithZero() {
        assertEquals(0, calculator.calculate("5*0"));
    }

    @Test
    @DisplayName("Should multiply numbers with multiple digits")
    void testMultiplicationWithLargeNumbers() {
        assertEquals(10000, calculator.calculate("100*100"));
    }

    @Test
    @DisplayName("Should divide two numbers")
    void testSimpleDivision() {
        assertEquals(3, calculator.calculate("6/2"));
    }

    @Test
    @DisplayName("Should handle integer division")
    void testIntegerDivision() {
        assertEquals(2, calculator.calculate("7/3"));
    }

    @Test
    @DisplayName("Should throw exception when dividing by zero")
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.calculate("8/0"),
                "Division by zero should throw ArithmeticException"
        );
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Should divide multiple numbers")
    void testMultipleDivision() {
        assertEquals(2, calculator.calculate("20/5/2"));
    }

    @Test
    @DisplayName("Should divide numbers with multiple digits")
    void testDivisionWithLargeNumbers() {
        assertEquals(10, calculator.calculate("1000/100"));
    }

    @Test
    @DisplayName("Should ignore whitespace in expression")
    void testIgnoreWhitespace() {
        assertEquals(10, calculator.calculate(" 2 * 5 "));
    }

    @Test
    @DisplayName("Should ignore whitespace with multiple operations")
    void testIgnoreWhitespaceMultipleOps() {
        assertEquals(6, calculator.calculate(" 1 + 2 + 3 "));
    }

    @Test
    @DisplayName("Should handle expression with tabs and spaces")
    void testIgnoreDifferentWhitespace() {
        assertEquals(8, calculator.calculate("  10  -  2    "));
    }

    @Test
    @DisplayName("Should respect multiplication precedence over addition")
    void testMultiplicationPrecedenceOverAddition() {
        assertEquals(13, calculator.calculate("1+2*6"));
    }

    @Test
    @DisplayName("Should respect multiplication precedence over subtraction")
    void testMultiplicationPrecedenceOverSubtraction() {
        assertEquals(7, calculator.calculate("15-4*2"));
    }

    @Test
    @DisplayName("Should respect division precedence over addition")
    void testDivisionPrecedenceOverAddition() {
        assertEquals(13, calculator.calculate("10+6/2"));
    }

    @Test
    @DisplayName("Should respect division precedence over subtraction")
    void testDivisionPrecedenceOverSubtraction() {
        assertEquals(7, calculator.calculate("10-6/2"));
    }

    @Test
    @DisplayName("Should handle multiple operators with precedence")
    void testMultipleOperatorsWithPrecedence() {
        assertEquals(9, calculator.calculate("2+3*4-5"));
    }

    @Test
    @DisplayName("Should handle consecutive high-precedence operators")
    void testConsecutiveHighPrecedence() {
        assertEquals(8, calculator.calculate("2*8/2"));
    }

    @Test
    @DisplayName("Should handle complex mixed operations")
    void testComplexMixedOperations() {
        assertEquals(15, calculator.calculate("10+20/2-5*1"));
    }

    @Test
    @DisplayName("Should throw exception for empty expression")
    void testEmptyExpression() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(""));
    }


}