package com.example.demo;

/**
 * Calculator for test coverage demonstration
 */
public class Calculator {
    
    /**
     * Add two numbers
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Subtract
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiply
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divide
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return (double) a / b;
    }
    
    /**
     * Check if number is even
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    /**
     * Factorial of a number
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is defined only for non-negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculate average of numbers array
     */
    public double average(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null");
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
    
    /**
     * Calculate square of a number
     */
    public double square(double number) {
        return number * number;
    }
    
    /**
     * Calculate square root of a number
     */
    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
        /**
     * Calculate power of a number (a^b)
     * @param base base number
     * @param exponent exponent
     * @return result of base^exponent
     */
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    
    /**
     * Find maximum value in array
     * @param numbers array of integers
     * @return maximum value
     */
    public int findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null");
        }
        
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
  }
    

