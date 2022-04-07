package com.springboot.workers.jdbcexample.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.jdbcexample.model.Worker;
import com.springboot.workers.jdbcexample.repository.WorkerRepository;

@RestController

public class WorkerController {
	
	@Autowired
	private WorkerRepository wrepo;
	
	@GetMapping("/worker/showWorker")
	public Worker showWorker(){
		try {
			return this.wrepo.getWorker(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/worker/all/showWorkers")
	public List<Worker> showWorkers(){
		
		try {
			return this.wrepo.getWorkers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/worker/create")
	public String addWorker(){
		try {
			this.wrepo.add(11, "ABC", "XYZ", 43000, new Date(System.currentTimeMillis()), "HR");
			return "Row added successfully!!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/worker/update")
	public String updateWorker(){
		try {
			this.wrepo.update(11, "IT");
			return "Row updated successfully!!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/worker/delete")
	public String deleteWorker(){
		try {
			this.wrepo.delete(11);
			return "Row deleted successfully!!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
