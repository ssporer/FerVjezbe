package vjezbe4.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncComponent {
    @Async
    public void asyncMethodWithConfiguredExecutor(int i){
        System.out.println(i + " " + Thread.currentThread().getName());
    }
}
