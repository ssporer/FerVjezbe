package hr.fer.java.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class AsyncTask {

    private static final Logger log = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public CompletableFuture<Void> write() throws InterruptedException {
        UUID uuid = UUID.randomUUID();
        for (int i = 0; i < 10; i++){
            log.info(uuid + ": Hello World");
        }
        return null;
    }
}
