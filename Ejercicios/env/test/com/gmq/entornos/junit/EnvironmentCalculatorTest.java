package com.gmq.entornos.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentCalculatorTest {

    EnvironmentCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new EnvironmentCalculator();
    }
    
    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @ParameterizedTest
    @MethodSource("divisionCalculator")
    void should_divide_two_positive_numbers
        (BigDecimal dividend, BigDecimal divisor, BigDecimal solution) {

        BigDecimal result = calculator.divide(dividend, divisor);
        assertEquals(result, solution);
    }

    static Stream<Arguments> divisionCalculator() {
        return Stream.of(
            Arguments.of(new BigDecimal(100), new BigDecimal(10),BigDecimal.TEN),
            Arguments.of(new BigDecimal(5), BigDecimal.ZERO, new BigDecimal(-1)),
            Arguments.of(new BigDecimal(0), BigDecimal.ZERO, new BigDecimal(-1)),
            Arguments.of(null, BigDecimal.ONE, new BigDecimal(-1))
        );
    }

}