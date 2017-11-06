package hr.fer.java.vjezbe.zadatak4.service;

import org.springframework.stereotype.Service;

import hr.fer.java.vjezbe.zadatak4.model.enums.Students;

@Service
public class ZelBarService {
	
	public String getMyName() {
		return Students.ZELBAR.toString();
	}
	
}
