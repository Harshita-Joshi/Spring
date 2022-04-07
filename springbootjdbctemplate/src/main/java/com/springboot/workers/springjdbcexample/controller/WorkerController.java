package com.springboot.workers.springjdbcexample.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.model.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;



@RestController

public class WorkerController {
	
	@Autowired
	private WorkerRepository wrepo;
	
	@GetMapping("/worker/showWorker")
	public Worker showWorker(){
		
		return this.wrepo.getWorker(5);
		
	}
	
	@GetMapping("/worker/all/showWorkers")
	public List<Worker> showWorkers(){
		
		return this.wrepo.getWorkers();
		
	}
	
	@GetMapping("/worker/create")
	public String addWorker(){
		this.wrepo.add(11, "ABC", "XYZ", 43000, new Date(System.currentTimeMillis()), "HR");
		return "Row added successfully!!";
	}
	
	@GetMapping("/worker/update")
	public String updateWorker(){
		this.wrepo.update(11, "IT");
		return "Row updated successfully!!";
	}
	
	@GetMapping("/worker/delete")
	public String deleteWorker(){
		this.wrepo.delete(11);
		return "Row deleted successfully!!";
	}
	
}
