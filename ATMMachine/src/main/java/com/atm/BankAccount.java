package com.atm;

abstract class BankAccount{
	
	int accNum;
	String accHolder;
	double accBalance;
	
	abstract void showBalance();
	abstract double withdraw(double amount);
	abstract double deposit(double amount);
	
	public BankAccount(int acNo, String acName, double balance ) {
		this.accNum = acNo;
		this.accHolder = acName;
		this.accBalance = balance;
	}
	
	@Override
	public String toString() {
		return "[accNum=" + accNum + ", accHolder=" + accHolder + ", accBalance=" + accBalance + "]";
	}
	
}