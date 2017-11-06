package hr.fer.java.vjezbe.zadatak4.component;

import org.springframework.stereotype.Component;

import hr.fer.java.vjezbe.zadatak4.model.enums.Students;

@Component
public class ZelBarComponent extends CoreComponent {

	@Override
	protected String setStudentName() {
		return Students.ZELBAR.toString();
	}

}
