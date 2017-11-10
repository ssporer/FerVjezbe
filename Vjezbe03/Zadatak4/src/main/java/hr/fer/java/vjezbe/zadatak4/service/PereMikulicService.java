package hr.fer.java.vjezbe.zadatak4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.java.vjezbe.zadatak4.component.PereMikulicComponent;

@Service
public class PereMikulicService {
	@Autowired
	private PereMikulicComponent component;
	
	public String getMyName() {
		return component.getMyName();
	}
}
