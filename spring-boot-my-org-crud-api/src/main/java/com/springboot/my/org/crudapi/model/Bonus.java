package com.springboot.my.org.crudapi.model;

import java.sql.Date;

public class Bonus {
	
	private int worker_ref_id;
	private int bonus_amount;
	private Date bonus_date;
	
	public Bonus(int worker_ref_id, int bonus_amount, Date bonus_date) {
		super();
		this.worker_ref_id = worker_ref_id;
		this.bonus_amount = bonus_amount;
		this.bonus_date = bonus_date;
	}

	public int getWorker_ref_id() {
		return worker_ref_id;
	}

	public void setWorker_ref_id(int worker_ref_id) {
		this.worker_ref_id = worker_ref_id;
	}

	public int getBonus_amount() {
		return bonus_amount;
	}

	public void setBonus_amount(int bonus_amount) {
		this.bonus_amount = bonus_amount;
	}

	public Date getBonus_date() {
		return bonus_date;
	}

	public void setBonus_date(Date bonus_date) {
		this.bonus_date = bonus_date;
	}

	@Override
	public String toString() {
		return "Bonus [worker_ref_id=" + worker_ref_id + ", bonus_amount=" + bonus_amount + ", bonus_date=" + bonus_date
				+ "]";
	}
	
	
	
}
