package hr.fer.java.vjezbe.zadatak4.component;

import org.springframework.stereotype.Component;

import hr.fer.java.vjezbe.zadatak4.model.enums.Students;

@Component
public class PereMikulicComponent extends CoreComponent{
	
	private static final String MY_NAME=Students.PERE_MIKULIC.toString();

	@Override
	protected String setStudentName() {
		return MY_NAME;
	}
	
	public String getMyName() {
		return MY_NAME;
	}

}
