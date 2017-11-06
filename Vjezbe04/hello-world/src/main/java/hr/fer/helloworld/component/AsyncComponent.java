package hr.fer.helloworld.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncComponent {

    @Async
    public void asyncMethodWithConfiguredExecutor(int i) {
        System.out.println(i + " - Execute method with configured executor - "
                + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());

    }
}
