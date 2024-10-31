package org.example.unit_testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorParametrizedTest {

    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @MethodSource(value = "generateSumParams")
    public void testSumWithParameters(String input, int expected) {
        //when
        int actual = calculator.sum(input);

        //then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> generateSumParams() {
        return Stream.of(
                Arguments.of("2+3", 5),
                Arguments.of("2+3+7", 12),
                Arguments.of("2+(-3)+7", 6),
                Arguments.of(" 2 + 3 ", 5),
                Arguments.of("+", 0),
                Arguments.of("", 0),
                Arguments.of(null, 0),
                Arguments.of("5+", 5)
        );
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