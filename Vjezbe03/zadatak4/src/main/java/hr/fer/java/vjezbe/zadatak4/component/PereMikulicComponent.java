package hr.fer.java.vjezbe.zadatak4.component;

import org.springframework.stereotype.Component;

import hr.fer.java.vjezbe.zadatak4.model.enums.Students;

@Component
public class PereMikulicComponent extends CoreComponent{

	@Override
	protected String setStudentName() {
		return Students.PERE_MIKULIC.toString();
	}

}
