package com.github.glo2003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;
    final static String String_1 = "1";
    final static String String_2 = "4,4";
    final static String String_3 = "4,,4";
    final static String String_4 = "1,";
    final static int Sum_String_2 = 8;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void whenEmptyString_thenReturnsZero() {
        int result = calculator.add("");

        assertEquals(0, result);
    }
    @Test
    void whenOnlyOneNumericalCharacter_thenReturnsConvertedVersion(){
        int result = calculator.add(String_1);

        assertEquals(Integer.parseInt(String_1), result);
    }
    @Test
    void whenOnlyOneNonNumericalCharacter_thenthrowInvalidInput(){
        assertThrows(InvalidNumberFormatException.class,
                () -> calculator.add("b"));
    }
    @Test
    void whenOnlyOneNumericalCharacterAndOneDelimiter_thenreturnsConvertedversion(){
        int result = calculator.add(String_4);
        assertEquals(Integer.parseInt(String_1), result);
    }
    void whenTwoNumericalCharactersAndOneDelimiter_thenReturnsTheSumOfConvertedVersions(){
        int result = calculator.add(String_2);
        assertEquals(Sum_String_2, result);
    }
    @Test
    void whenTwoNumericalCharactersAndManyDelimiters_thenReturnsTheSumOfConvertedVersions(){
        int result = calculator.add(String_3);
        assertEquals(Sum_String_2, result);
    }
    void whenNonNumericValues_thenThrowInvalidInput() {
        assertThrows(InvalidNumberFormatException.class,
                () -> calculator.add("4,a"));
    }
}