package com.gmq.entornos.map;

import java.util.HashMap;
import java.util.Map;

public class GQMCustomMap implements CustomMap<Integer, String> {

	private Map<Integer, String> embebbedMap = new HashMap<Integer, String>();
	
	@Override
	public CustomMap<Integer, String> put(Integer key, String value) {

		embebbedMap.put(key, value);
		return this;
	}

	@Override
	public boolean containsKey(Integer key) {
		
		System.out.println("Contains key ... ");
		return embebbedMap.containsKey(key);
	}

	@Override
	public String get(Integer key) {

		System.out.println("Getting value for key ... "+key);
		return embebbedMap.get(key);
	}
}
