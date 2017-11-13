package hr.fer.java.vjezbe.zadatak4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.java.vjezbe.zadatak4.service.ZelBarService;

@RestController
public class ZelBarController {

	@Autowired
	private ZelBarService service;
	
	@GetMapping("/zelbar/name")
	public String getStudentName() {
		return service.getMyName();
	}
}
