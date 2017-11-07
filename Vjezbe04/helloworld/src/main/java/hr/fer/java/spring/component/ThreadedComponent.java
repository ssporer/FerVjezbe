package hr.fer.java.spring.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;


/**
 * Created by Mislav on 6.11.2017..
 */
@Component
public class ThreadedComponent {
    private static final Logger logger = LoggerFactory.getLogger(ThreadedComponent.class);

    @Async
    public CompletableFuture<String> log(CountDownLatch cdl)throws InterruptedException{
        UUID uuid = UUID.randomUUID();
        System.out.println("Starting thread");
        for(int i = 0; i < 10; i++) {
            logger.info("Thread UUID: " + uuid.toString());
            Thread.sleep(500);
        }
        cdl.countDown();
        return CompletableFuture.completedFuture(uuid.toString());
    }

}
