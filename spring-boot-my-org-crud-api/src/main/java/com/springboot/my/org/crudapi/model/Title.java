package com.springboot.my.org.crudapi.model;

import java.sql.Date;

public class Title {
	
	private int worker_ref_id;
	private String worker_title;
	private Date affected_from;
	
	public Title(int worker_ref_id, String worker_title, Date affected_from) {
		super();
		this.worker_ref_id = worker_ref_id;
		this.worker_title = worker_title;
		this.affected_from = affected_from;
	}

	public int getWorker_ref_id() {
		return worker_ref_id;
	}

	public void setWorker_ref_id(int worker_ref_id) {
		this.worker_ref_id = worker_ref_id;
	}

	public String getWorker_title() {
		return worker_title;
	}

	public void setWorker_title(String worker_title) {
		this.worker_title = worker_title;
	}

	public Date getAffected_from() {
		return affected_from;
	}

	public void setAffected_from(Date affected_from) {
		this.affected_from = affected_from;
	}

	@Override
	public String toString() {
		return "Title [worker_ref_id=" + worker_ref_id + ", worker_title=" + worker_title + ", affected_from="
				+ affected_from + "]";
	}
	
	
}
