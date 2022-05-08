package com.bank.testcases;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bank.exception.NegativeBalanceException;
import com.bank.exception.OutOfLimitException;
import com.bank.exception.ZeroAmountException;
import com.training.bank.Bank;

class BankTest {
	Bank bank = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bank = new Bank(5000);
	}

	@AfterEach
	void tearDown() throws Exception {
		bank = null;
	}

	@Test
	@DisplayName("Testing positive Deposit")
	void testPositiveDeposit() throws NegativeBalanceException, ZeroAmountException {
		int amount = 2000;
		assertEquals(7000,bank.deposit(amount));
	}
	
	@Test
	@DisplayName("Testing Negative Deposit")
	void testNegativeDeposit() {
		int amount = -8292;
		assertThrows(NegativeBalanceException.class,()->bank.deposit(amount));
	}
	@Test
	@DisplayName("Testing Zero Deposit")
	void testZeroDepsit() {
		int amount=0;
		assertThrows(ZeroAmountException.class,()->bank.deposit(amount));
	}

	@Test
	@DisplayName("Testing Postive Withdraw")
	void testPositiveWithdraw() throws OutOfLimitException, NegativeBalanceException, ZeroAmountException {
		int amount = 2000;
		assertEquals(3000,bank.withdraw(amount));
	}
		
	
	@Test
	@DisplayName("Out of Limit Withdraw")
	void testOutOfLimitWithdraw() {
		int amount =15000;
		assertThrows(OutOfLimitException.class,()->bank.withdraw(amount));
}
	@Test
	@DisplayName("Negative withdraw")
	void testNegativeWithdraw() {
		int amount1 =-3456;
		assertThrows(NegativeBalanceException.class,()->bank.withdraw(amount1));
	}
	@Test 
	@DisplayName("Zero amount withdraw")
	void testZeroWithdraw() {
		int amount=0;
		assertThrows(ZeroAmountException.class,()->bank.withdraw(amount));
	}
}