package com.gmq.entornos.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RefactoringTest {

    Refactoring refactoring;

    @BeforeEach
    void setUp() {
        refactoring = new Refactoring();
    }

    @ParameterizedTest
    @MethodSource("starting")
    void should_start(List<Item> items) {
        List<Item> results = refactoring.start(items);

        for(Item result: results) {
            switch(result.name) {
                case "Car":
                    assertEquals(100, result.quality);
                    assertEquals(9, result.sold);
                    break;
                case "Bus":
                    assertEquals(50, result.quality);
                    assertEquals(19, result.sold);
                    break;
                case "Truck":
                    assertEquals(0, result.quality);
                    assertEquals(-1, result.sold);
                    break;
                case "Bike":
                    assertEquals(49, result.quality);
                    assertEquals(14, result.sold);
                    break;
            }
        }
    }

    static Stream<Arguments> starting() {
        return Stream.of(
            Arguments.of(new ArrayList())
        );
    }
}