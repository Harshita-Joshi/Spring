package com.springboot.workers.springjdbcexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
	
	@RequestMapping("/")
	public String welcomeMessage() {
		return "Hello visitor!\nVisiting time: "+System.currentTimeMillis();
	}
	
}
