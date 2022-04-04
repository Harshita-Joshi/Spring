package com.springboottask1.controllerTask.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@GetMapping("/task")
	public String taskDemoMessage() {
		return "Task demonstration";
	}
	
	
	@GetMapping("/task/showMyInfo")
	public String personalInfoMessage() {
		return "Name: Tom \nCity: California \nState: US \nDream Job: Rat Catcher";
	}
	
	
	@GetMapping("/task/showMyHobbies")
	public List<String> hobbiesMessage() {
		return List.of("Rat catching", "Housekeeping", "Reading");
	}
	
}
