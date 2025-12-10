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
        assertEquals("Делитель не может быть нулем", exception.getMessage());
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
        assertEquals("Факториал определен только для неотрицательных чисел", 
                    exception.getMessage());
    }
}
