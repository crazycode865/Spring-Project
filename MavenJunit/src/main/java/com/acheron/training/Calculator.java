package com.acheron.training;

public class Calculator {
	
	public int add(int num1,int num2) {
		return num1+num2;
	}
	public int difference(int num1,int num2) {
		return num1-num2;
	}
	public int division(int num1,int num2) {
		return num1/num2;
	}
	public int product(int num1,int num2) {
		return num1*num2;
	}

	public String greetUser(String name) {
		return ("WELCOME "+name.toUpperCase());
	}

}