package com.atm;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawalEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher appPublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.appPublisher = publisher;
	}	
	
	public void publish(int amt, BankAccount bankacc) {
		WithdrawalEvent event = new WithdrawalEvent(this);
		event.setAmount(amt);
		event.setBankAccount(bankacc);
		this.appPublisher.publishEvent(event);
	}
}