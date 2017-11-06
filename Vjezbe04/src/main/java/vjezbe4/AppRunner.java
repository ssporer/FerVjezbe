package vjezbe4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vjezbe4.component.AsyncComponent;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private AsyncComponent asyncComponent;

    public void run(String... args) throws Exception {
        for(int i = 0; i < 10; i++){
            asyncComponent.asyncMethodWithConfiguredExecutor(i);
        }
    }
}
