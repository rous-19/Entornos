package com.gmq.entornos.demo;

public class Factorial {

	
	
	public int calculateFactorial(int number) {
		
		System.out.println("hola");
		
		int factorial = 1;
		for (int i = number; i > 1; i--) {
			factorial = factorial*i;
		}
		return factorial;
	}
}
