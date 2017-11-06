package hr.fer.vjezbe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping
	public String getHello() {
		return "Hello World";
	}
	
}
