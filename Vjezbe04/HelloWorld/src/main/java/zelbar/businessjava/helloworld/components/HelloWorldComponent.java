package zelbar.businessjava.helloworld.components;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldComponent {

	@PostConstruct
	public void init() {
		System.out.println("Hello world!");
	}
}
