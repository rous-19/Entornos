/**
 * 
 */
package com.gmq.entornos.demo;

/**
 * @author Raul.Camarero
 *
 */
public class MemoryApplication {

	private final static int SIZE = 10000000; 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true) {
			new HugeMemory(SIZE);
		}
	}
}

































