package hr.fer.java.vjezbe.zadatak4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.java.vjezbe.zadatak4.service.PereMikulicService;

@RestController
public class PereMikulicController {
	
	@Autowired
	private PereMikulicService service;
	
	@GetMapping("/pereMikulic")
	public String getMyName() {
		return service.getMyName();
	}
	
}
