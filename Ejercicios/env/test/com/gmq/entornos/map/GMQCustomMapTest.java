package com.gmq.entornos.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GMQCustomMapTest {
	
	GMQCustomMap gmqCustomMap;
	
	@BeforeEach
	void setUp() {
		
		gmqCustomMap = new GMQCustomMap();
	}
	
	@ParameterizedTest
	@MethodSource("shouldPut")
	void should_add_a_key_and_value(Integer key, String value) {
		
		CustomMap<Integer, String> returnedMap = gmqCustomMap.put(key, value);
		
		assertNotNull(returnedMap);
		assertTrue(returnedMap.containsKey(key));
		assertEquals(returnedMap.get(key), value);
	}
	
	static Stream<Arguments> shouldPut() {
		return Stream.of(
				Arguments.of(1, "first"),
				Arguments.of(2, "second"),
				Arguments.of(3, "third")
				);
	}
	
	@ParameterizedTest
	@MethodSource("shouldContains")
	void should_contains_key(Integer key, boolean result) {
				
		gmqCustomMap.put(1, "first");
		gmqCustomMap.put(2, "second");
		
		boolean returnedValue = gmqCustomMap.containsKey(key);
		
		assertEquals(returnedValue, result);
	}
	
	static Stream<Arguments> shouldContains() {
		
		return Stream.of(
				Arguments.of(1, true),
				Arguments.of(3, false)
				);
	}
	
	@ParameterizedTest
	@MethodSource("shouldGet")
	void should_get_value_from_key(Integer key, String value) {
				
		gmqCustomMap.put(1, "first");
		gmqCustomMap.put(2, "second");
		
		String result = gmqCustomMap.get(key);
		assertEquals(result, value);
	}
	
	static Stream<Arguments> shouldGet() {
		
		return Stream.of(
				Arguments.of(1, "first"),
				Arguments.of(2, "second")
				);
	}

}
