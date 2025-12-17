package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(-5, calculator.add(-2, -3));
    }
    
    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-1, calculator.subtract(2, 3));
        assertEquals(0, calculator.subtract(5, 5));
    }
    
    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-6, calculator.multiply(2, -3));
    }
    
    @Test
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
        assertEquals(3.0, calculator.divide(9, 3), 0.001);
    }
    
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Divisor cannot be zero", exception.getMessage());
    }
    
    @Test
    void testIsEven() {
        assertTrue(calculator.isEven(2));
        assertTrue(calculator.isEven(0));
        assertFalse(calculator.isEven(3));
        assertFalse(calculator.isEven(-1));
    }
    
    @Test
    void testFactorial() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(120, calculator.factorial(5));
        assertEquals(3628800, calculator.factorial(10));
    }
    
    @Test
    void testFactorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-5);
        });
        assertEquals("Factorial is defined only for non-negative numbers", 
                    exception.getMessage());
    }
    
    @Test
    void testAverage() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(3.0, calculator.average(numbers), 0.001);
    }
    
    @Test
    void testAverageEmptyArray() {
        int[] emptyArray = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(emptyArray);
        });
        assertEquals("Array cannot be empty or null", exception.getMessage());
    }
    
    @Test
    void testAverageNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(null);
        });
        assertEquals("Array cannot be empty or null", exception.getMessage());
    }
    
    @Test
    void testSquare() {
        assertEquals(4.0, calculator.square(2.0), 0.001);
        assertEquals(9.0, calculator.square(3.0), 0.001);
        assertEquals(0.0, calculator.square(0.0), 0.001);
        assertEquals(6.25, calculator.square(2.5), 0.001);
    }
    
    @Test
    void testSquareRoot() {
        assertEquals(2.0, calculator.squareRoot(4.0), 0.001);
        assertEquals(3.0, calculator.squareRoot(9.0), 0.001);
        assertEquals(0.0, calculator.squareRoot(0.0), 0.001);
        assertEquals(1.5, calculator.squareRoot(2.25), 0.001);
    }
    
    @Test
    void testSquareRootNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.squareRoot(-4.0);
        });
        assertEquals("Cannot calculate square root of negative number", exception.getMessage());
    }
        @Test
    void testPower() {
        // Positive exponent
        assertEquals(8.0, calculator.power(2.0, 3), 0.001);
        assertEquals(1.0, calculator.power(5.0, 0), 0.001);
        assertEquals(0.25, calculator.power(2.0, -2), 0.001);
        
        // Decimal base
        assertEquals(6.25, calculator.power(2.5, 2), 0.001);
    }
    
    @Test
    void testPowerWithZeroBase() {
        assertEquals(0.0, calculator.power(0.0, 3), 0.001);
        assertEquals(1.0, calculator.power(0.0, 0), 0.001);
    }
    
    @Test
    void testFindMax() {
        int[] numbers = {3, 7, 2, 9, 1};
        assertEquals(9, calculator.findMax(numbers));
        
        int[] singleElement = {5};
        assertEquals(5, calculator.findMax(singleElement));
        
        int[] negativeNumbers = {-3, -7, -2, -9};
        assertEquals(-2, calculator.findMax(negativeNumbers));
    }
    
    @Test
    void testFindMaxEmptyArray() {
        int[] emptyArray = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.findMax(emptyArray);
        });
        assertEquals("Array cannot be empty or null", exception.getMessage());
    }
    
    @Test
    void testFindMaxNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.findMax(null);
        });
        assertEquals("Array cannot be empty or null", exception.getMessage());
    }
}
