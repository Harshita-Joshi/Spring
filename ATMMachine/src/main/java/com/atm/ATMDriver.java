package com.atm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.atm.WithdrawalEventPublisher;

public class ATMDriver{
	
	public static void main(String[] args) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 SavingsAccount savingsAcc = (SavingsAccount) context.getBean("savingsAccount");
		 SalaryAccount salaryAcc = (SalaryAccount) context.getBean("salaryAccount");
		 
		 WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("customEventPublisher");
		 
		 if(savingsAcc.withdraw(30000)==0)
			 publisher.publish(30000, savingsAcc);
		 else
			 publisher.publish(0, salaryAcc);
		 
		 if(salaryAcc.withdraw(50000)==0)
			 publisher.publish(50000, salaryAcc);
		 else 
			 publisher.publish(0,  salaryAcc);
		
	}
	
}