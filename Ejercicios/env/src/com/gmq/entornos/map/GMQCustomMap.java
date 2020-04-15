package com.gmq.entornos.map;

import java.util.HashMap;
import java.util.Map;

/**
 * GMQCustom implementation of a map
 * 
 * @author Raul.Camarero
 *
 */
public class GMQCustomMap implements CustomMap<Integer, String> {

	private Map<Integer, String> embebbedMap = new HashMap<Integer, String>();
	
	/**
	 * Adds a key and a value to the CustomMap
	 * 
	 * @param key unique key in map
	 * @param value value for a key
	 * @return current CustomMap
	 */
	@Override
	public CustomMap<Integer, String> put(Integer key, String value) {

		embebbedMap.put(key, value);
		return this;
	}

	/**
	 * Checks if the key is present
	 * 
	 * @param key present
	 * @return true if present
	 */
	@Override
	public boolean containsKey(Integer key) {
		
		System.out.println("Contains key ... ");
		return embebbedMap.containsKey(key);
	}

	/**
	 * 
	 * Returns value from key in map
	 * 
	 * @param key the key
	 * @return String the value
	 */
	@Override
	public String get(Integer key) {

		System.out.println("Getting value for key ... "+key);
		return embebbedMap.get(key);
	}
}
