package hr.fer.vjezbe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	
	@Scheduled(fixedRate = 2000)
	public void reportHello() {
		log.info("Hello world");
	}
}
