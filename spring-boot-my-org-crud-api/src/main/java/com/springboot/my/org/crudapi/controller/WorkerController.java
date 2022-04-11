package com.springboot.my.org.crudapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	WorkerService wService;
	
	@GetMapping("/showWorker/{id}")
	public Worker showWorker(@PathVariable int id) {
		return wService.getWorker(id);
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return wService.getWorkers();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Worker worker) {
		return wService.createWorker(worker);	
	}

	@PatchMapping("/update/{id}")
	public boolean update(@PathVariable int id,@RequestBody Map<String,String> requestBody) {
		return wService.updateWorker(id,requestBody.get("email"));
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return wService.deleteWorkerById(id);
	}
	
	@GetMapping("/all/details")
	public List<Map<String,String>> getFullInfo(){
		return wService.getWorkerDetails();
	}
	
}