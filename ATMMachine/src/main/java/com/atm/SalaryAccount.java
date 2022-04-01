package com.atm;

public class SalaryAccount extends BankAccount {
	
	public SalaryAccount(int acNo, String acName, double bal) {
		super(acNo, acName, bal);
	}

	@Override
	void showBalance() {
		// TODO Auto-generated method stub
		System.out.println("Salary account balance: "+this.accBalance);
	}

	@Override
	double withdraw(double amount) {
		// TODO Auto-generated method stub
		if(amount>100000 || amount>this.accBalance)
			return -1;
		return 0;
	}

	@Override
	double deposit(double amount) {
		// TODO Auto-generated method stub
		this.accBalance += amount;
		return this.accBalance;
	}
	
	
	
}
