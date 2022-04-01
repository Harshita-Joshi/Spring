package com.atm;

import org.springframework.context.ApplicationEvent;

public class WithdrawalEvent extends ApplicationEvent {

	int amount;
	BankAccount bankac;
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankac = bankAccount;
		this.bankac.accBalance -= this.amount;
	}
	
	public WithdrawalEvent(Object source) {
		super(source);
	}
	
	public String message() {
		return "Amount withdrawn: "+this.amount+" Balance: "+this.bankac.accBalance+" At timestamp: "+ this.getTimestamp();
	}
}