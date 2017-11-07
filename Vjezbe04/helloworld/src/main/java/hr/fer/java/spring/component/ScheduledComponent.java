package hr.fer.java.spring.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Mislav on 6.11.2017..
 */
@Component
public class ScheduledComponent {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledComponent.class);

    @Scheduled(fixedRate = 2000)
    public void sayHello(){
        logger.info("Hello World!");
    }
}
