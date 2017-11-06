package hr.fer.java.vjezbe.component.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Igor Farszky on 6.11.2017..
 */
@Component
public class ThreadingUUID {

    private static final Logger log = LoggerFactory.getLogger(ThreadingUUID.class);

    @Async
    public void printThreadId() throws InterruptedException {
        UUID uid = UUID.randomUUID();
        for (int i = 0; i < 10; i++) {
            log.info(i + ". UUID=" + uid.toString());
            Thread.sleep(500);
        }
    }

}
