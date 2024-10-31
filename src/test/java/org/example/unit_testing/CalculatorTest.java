package org.example.unit_testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void whenTwoValidNumbers_thenSumIsCorrect() {
        //given
        String input = "2+3";
        int expected = 5;

        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void whenThreeValidNumbers_thenSumIsCorrect() {
        //given
        String input = "2+3+7";
        int expected = 12;

        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void whenNegativeNumbers_thenSumIsCorrect() {
        //given
        String input = "2+(-3)+7";
        int expected = 6;

        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void whenTwoValidNumbersWithSpaces_thenSumIsCorrect() {
        //given
        String input = " 2 + 3 ";
        int expected = 5;

        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void whenStringIsJustAPlus_thenResultIsZero() {
        //given
        String input = "+";
        int expected = 0;

        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void whenStringIsEmpty_thenResultIsZero() {
        //given
        String input = "";
        int expected = 0;

        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void whenStringEndsWithAPlus_thenResultIsCorrect() {
        //given
        String input = "5+";
        int expected = 5;

        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void whenNumberTooLarge_thenExceptionIsThrown() {
        //given
        String largeInteger = "3000000000";
        String input = "2+" + largeInteger;

        //when
        NumberFormatException exception =
                assertThrows(NumberFormatException.class, () -> calculator.sum(input));

        //then
        assertTrue(exception.getMessage().contains(largeInteger));
    }

    @Test
    public void whenInputHasLetters_thenExceptionIsThrown() {
        //given
        String invalidInteger = "stefan";
        String input = "2+" + invalidInteger;

        //when
        NumberFormatException exception =
                assertThrows(NumberFormatException.class, () -> calculator.sum(input));

        //then
        assertTrue(exception.getMessage().contains(invalidInteger));
    }
}