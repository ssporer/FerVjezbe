package vjezbe4.component;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledLogger {
    Logger logger = Logger.getLogger(ScheduledLogger.class);

    @Scheduled(fixedDelay = 2000)
    public void helloWorld(){
        logger.debug("Hello world!");
    }
}
