package com.springboot.my.org.crudapi.model;

import java.sql.Date;

public class Worker{
    private int worker_id;
    private String first_name;
    private String last_name;
    private int salary;
    private Date joining_date;
    private String department;
    private String email;

    public Worker() {
    	
    }
    
    public Worker(int workerId, String firstName, String lastName, int salary, Date joiningDate,
            String department, String email) {
        this.worker_id = workerId;
        this.first_name = firstName;
        this.last_name = lastName;
        this.salary = salary;
        this.joining_date = joiningDate;
        this.department = department;
        this.email = email;
    }

    public int getWorkerId() {
        return worker_id;
    }

    public void setworkerId(int workerId) {
        this.worker_id = workerId;
    }

    public String getfirstName() {
        return first_name;
    }

    public void setfirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getlastName() {
        return last_name;
    }

    public void setlastName(String lastName) {
        this.last_name = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getjoiningDate() {
        return joining_date;
    }

    public void setjoiningDate(Date joiningDate) {
        this.joining_date = joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "Worker [worker_id=" + worker_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", salary=" + salary + ", joining_date=" + joining_date + ", department=" + department + ", email="
				+ email + "]";
	}

   
}
