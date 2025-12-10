package com.example.demo;

/**
 * Утилиты для работы со строками
 */
public class StringUtils {
    
    /**
     * Проверка, является ли строка палиндромом
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    /**
     * Подсчет гласных в строке
     */
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouаеёиоуыэюя";
        String lowerStr = str.toLowerCase();
        
        for (char c : lowerStr.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Обратная строка
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
