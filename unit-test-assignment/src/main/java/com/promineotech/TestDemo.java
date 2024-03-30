package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a+b;
		}
		else {
			throw new IllegalArgumentException("Both parametters must be positive!");
		}
		
	}
	
	
	public int multiplyOnlyOneNegative(int a, int b) {
		
		//this code demands exactly one negative number be multiplied.
		if ((a <0 && b>=0) || (a>=0 && b < 0)) {
			return a*b;
		}
		else {
			throw new IllegalArgumentException("There must be one, and only one, negative number.");
		}
	}
	
	
	public int randomNumberSquared() {
		int i = getRandomInt();
		return i*i;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10)+1;
	}
	
	
	
	
//	public boolean sumIsMultipleOfNine(int a, int b) {
//		int i = a+b;
//		
//		if (i%9==0) {
//			return true;
//		} else {
//			throw new IllegalArgumentException("Sum is not divisible by nine.");
//		}
//	}
	
}
