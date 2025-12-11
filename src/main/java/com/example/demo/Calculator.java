package com.example.demo;

/**
 * Калькулятор для демонстрации тестового покрытия
 */
public class Calculator {
    
    /**
     * Сложение двух чисел
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Вычитание
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Умножение
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Деление
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Делитель не может быть нулем");
        }
        return (double) a / b;
    }
    
    /**
     * Проверка на четность
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    /**
     * Факториал числа
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
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
}
// Trigger second SonarCloud analysis - 2025-12-11 11:08
// Last analysis: 2025-12-11 11:13
