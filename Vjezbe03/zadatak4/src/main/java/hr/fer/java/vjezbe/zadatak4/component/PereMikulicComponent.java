package hr.fer.java.vjezbe.zadatak4.component;

import org.springframework.stereotype.Component;

@Component
public class PereMikulicComponent extends CoreComponent{

	@Override
	protected String setStudentName() {
		return "Pere Mikulić";
	}

}
