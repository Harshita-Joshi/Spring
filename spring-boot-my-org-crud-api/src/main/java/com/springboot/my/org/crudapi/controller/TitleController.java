package com.springboot.my.org.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.service.TitleService;

@RestController
@RequestMapping("/worker/title")
public class TitleController {
	@Autowired
	TitleService titleService;
	
	@GetMapping("/showTitle/{id}")
	public Title showTitle(@PathVariable int id) {
		return titleService.findTitleById(id);
	}
	
	@GetMapping("/showAllTitles")
	public List<Title> showAllTitles() {
		return titleService.findAllTitles();
	}
	
	
	@PostMapping("/{id}/promote/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@PathVariable int id, @PathVariable String title) {
		return titleService.createTitleById(id, title);	
	}
	
	@DeleteMapping("/{id}/removeTitle")
	public boolean delete(@PathVariable int id) {
		return titleService.deleteTitleById(id);
	}
	
}