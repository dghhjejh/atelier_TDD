package com.github.glo2003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;
    final static String STRING_1 = "1";
    final static String STRING_2 = "4,4";
    final static String STRING_3 = "4,,4";
    final static String STRING_4 = "1,";
    final static String STRING_5 = "1,2,3";
    final static String STRING_6 = "1,2,3,4,5";
    final static int SUM_STRING_2 = 8;
    final static int SUM_STRING_3 = 6;
    final static int SUM_STRING_5 = 15;


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
        int result = calculator.add(STRING_1);

        assertEquals(Integer.parseInt(STRING_1), result);
    }
    @Test
    void whenOnlyOneNonNumericalCharacter_thenthrowInvalidInput(){
        assertThrows(InvalidNumberFormatException.class,
                () -> calculator.add("b"));
    }
    @Test
    void whenOnlyOneNumericalCharacterAndOneDelimiter_thenreturnsConvertedversion(){
        int result = calculator.add(STRING_4);
        assertEquals(Integer.parseInt(STRING_1), result);
    }
    @Test
    void whenTwoNumericalCharactersAndOneDelimiter_thenReturnsTheSumOfConvertedVersions(){
        int result = calculator.add(STRING_2);
        assertEquals(SUM_STRING_2, result);
    }
    @Test
    void whenTwoNumericalCharactersAndManyDelimiters_thenReturnsTheSumOfConvertedVersions(){
        int result = calculator.add(STRING_3);
        assertEquals(SUM_STRING_2, result);
    }
    @Test
    void whenThreeNumericalCharactersAndManyDelimiters_thenReturnsTheSumOfConvertedVersions(){
        int result = calculator.add(STRING_5);
        assertEquals(SUM_STRING_3, result);
    }
    @Test
    void whenFiveNumericalCharactersAndManyDelimiters_thenReturnsTheSumOfConvertedVersions(){
        int result = calculator.add(STRING_6);
        assertEquals(SUM_STRING_5, result);
    }
    @Test
    void whenNonNumericValues_thenThrowInvalidInput() {
        assertThrows(InvalidNumberFormatException.class,
                () -> calculator.add("4,a"));
    }
}