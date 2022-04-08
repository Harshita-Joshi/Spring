package com.springboot.workers.crudapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.util.DateTimeUtilities;


@RestController

public class HomeController {
	
	@RequestMapping("/")
	public String welcomeMessage() {
		return "Hello visitor!\nVisiting time: "+DateTimeUtilities.getTime();
	}
	
}
