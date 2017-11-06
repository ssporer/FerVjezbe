package zelbar.businessjava.helloworld.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledHelloWorldComponent {
	
	private static final Logger log = LoggerFactory
			.getLogger(ScheduledHelloWorldComponent.class);

	@Scheduled(fixedRate = 2000)
	public void greet() {
		log.info("Hello World");
	}
}
