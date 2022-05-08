package com.training.bank;

import com.bank.exception.NegativeBalanceException;
import com.bank.exception.OutOfLimitException;
import com.bank.exception.ZeroAmountException;

public class Bank  {
	double balance;
	
	public Bank() {
		super();
	}
	public Bank(double balance) {
		super();
		this.balance = balance;
	}
	public double deposit(int amount) throws NegativeBalanceException, ZeroAmountException {
		if(amount<0)
			throw new NegativeBalanceException("Negative Balance");
		else if(amount==0)
			throw new ZeroAmountException("Zero Amount");
		return balance+amount;
		
	}
	public double withdraw(int amount) throws OutOfLimitException, NegativeBalanceException, ZeroAmountException {
		if(amount>this.balance)
			throw new OutOfLimitException("Out of Limit");
		else if(amount<0)
			throw new NegativeBalanceException("Negative Amount");
		if(amount==0)
			throw new ZeroAmountException("Zero amount withdraw");
		return this.balance- amount;
	}

}
