package com.atm;

public class SavingsAccount extends BankAccount {
	
	public SavingsAccount(int acNo, String acName, double bal) {
		super(acNo, acName, bal);
	}

	@Override
	void showBalance() {
		// TODO Auto-generated method stub
		System.out.println("Savings account balance: "+this.accBalance);
	}

	@Override
	double withdraw(double amount) {
		// TODO Auto-generated method stub
		if(amount>30000 || amount>this.accBalance)
			return -1;
		return 0;
	}

	@Override
	double deposit(double amount) {
		// TODO Auto-generated method stub
		if(amount > 1000000)
			return -1;
		this.accBalance += amount;
		return this.accBalance;
	}
	
	
	
}
