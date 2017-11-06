package hr.fer.java.vjezbe.component.impl;

import hr.fer.java.vjezbe.component.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Igor Farszky on 6.11.2017..
 */
@Component
public class HelloWorldScheduleImpl implements Scheduler {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldScheduleImpl.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    @Scheduled(fixedRate = 2000)
    public void printHelloWorld() {
        log.info("Hello world at {}", dateFormat.format(new Date()));
    }

}
