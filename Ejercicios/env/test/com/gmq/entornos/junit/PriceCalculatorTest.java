package com.gmq.entornos.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PriceCalculatorTest {

	PriceCalculator priceCalculator;
	
	@BeforeEach
	void setUp() throws Exception {
		priceCalculator = new PriceCalculator();
	}

	@ParameterizedTest
	@MethodSource("calculateProductPrices")
	void should_sum_product_prices(String productName, int quantity, int result) throws CalculatePriceException {
		Double productPrice = priceCalculator.calculatePrice(productName, quantity);
		assertEquals(result, productPrice);
	}
	
	@ParameterizedTest
	@MethodSource("calculateProductPricesException")
	void throws_calculate_price_exception(String productName, int quantity) throws CalculatePriceException {
		assertThrows(CalculatePriceException.class, () -> priceCalculator.calculatePrice(productName, quantity));
	}
	
	static Stream<Arguments> calculateProductPrices(){
		return Stream.of(
				Arguments.of("CAR", 1, 15000),
				Arguments.of("HOUSE", 10, 350000),
				Arguments.of("TRUCK", 100, 60000));
	}
	
	static Stream<Arguments> calculateProductPricesException() {
		return Stream.of(
				Arguments.of("car", 1),
				Arguments.of("default", 1));
	}

}
