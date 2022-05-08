package com.testcases.calcapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acheron.training.Calculator;

public class CalculatorTest {
	Calculator calc=null;

	@BeforeAll
	public static void init() {
		System.out.println("run before all the test case");
	}
	
	@BeforeEach
	public void setup() {
		calc = new Calculator();
		System.out.println("Runs before each test case");
	}
	
	@Test
	public void testAdd() {
		int actualResult = calc.add(20,30);
		assertEquals(50,actualResult,"The expected result is 50");
	}
	
	@Test
	public void testProduct() {
		assertEquals(90,calc.product(10, 9),"The product is 90");
	}
	
	@Test
	public void testDifference() {
		assertEquals(20,calc.difference(50, 30),"The product is 20");
	}
	
	@Test
	public void testDivision() {
		assertEquals(10,calc.division(100, 10),"The product is 90");
	}
	
	@Test
	public void testGreetUser() {
		assertEquals("WELCOME AWADHESH", calc.greetUser("Awadhesh"));
	}
	@AfterEach
	public void teardown() {
		calc= null;
		System.out.println("Runs after each test case");
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("runs after all test case");
	}
	
}
