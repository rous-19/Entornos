package com.gmq.entornos.map;

public interface CustomMap<K,V> {

	CustomMap<K,V> put(K key, V value);
	
	boolean containsKey(K key);
}
