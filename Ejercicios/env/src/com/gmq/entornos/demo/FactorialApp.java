package com.gmq.entornos.demo;

public class FactorialApp {

	public static void main(String[] args) {
		
		int originalNumber = Integer.valueOf(args[0]);
		int factorial = calculateFactorial(originalNumber);
		System.out.println("El factorial es "+factorial);
	}

	public static int calculateFactorial(int number) {
		int factorial = 1;
		for (int i = number; i > 1; i--) {
			factorial = factorial*i;
		}
		return factorial;
	}

	
	

}
