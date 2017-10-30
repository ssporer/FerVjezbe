package hr.fer.java.vjezbe.zadatak4.component;

import org.springframework.stereotype.Component;

@Component
public class ZelBarComponent extends CoreComponent {

	@Override
	protected String setStudentName() {
		return "Zeljko";
	}

}
