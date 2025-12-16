package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    
    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"));
        assertTrue(StringUtils.isPalindrome("12321"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome(null));
    }
    
    @Test
    void testCountVowels() {
        assertEquals(3, StringUtils.countVowels("Hello World"));
        assertEquals(5, StringUtils.countVowels("Education"));
        assertEquals(0, StringUtils.countVowels("bcdfg"));
        assertEquals(0, StringUtils.countVowels(""));
        assertEquals(0, StringUtils.countVowels(null));
    }
    
    @Test
    void testReverse() {
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("123", StringUtils.reverse("321"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }
    
    @Test
    void testIsPalindromeWithSpaces() {
        assertTrue(StringUtils.isPalindrome("race car"));
    }
    
    @Test
    void testCountVowelsMixedCase() {
        assertEquals(3, StringUtils.countVowels("Hello World!"));  // ИСПРАВЛЕНО: было 4
        assertEquals(3, StringUtils.countVowels("HELLO WORLD"));   // ИСПРАВЛЕНО: было 4
    }
    
    @Test
    void testReverseSpecialCharacters() {
        assertEquals("!dlroW olleH", StringUtils.reverse("Hello World!"));
    }
}
