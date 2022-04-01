package com.atm;

import org.springframework.context.ApplicationListener;

public class TransactionEventListener implements ApplicationListener<WithdrawalEvent> {
	
	private void sendSMS(String msg) {
		System.out.println(msg);
	}
	
	public void onApplicationEvent(WithdrawalEvent event) {
		 sendSMS(event.message());
	}
}