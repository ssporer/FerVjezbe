package hr.fer.helloworld;

import hr.fer.helloworld.component.AsyncComponent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private AsyncComponent asyncComponent;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("AAA");
        for(int i = 0; i<10; i++){
            asyncComponent.asyncMethodWithConfiguredExecutor(i);
        }
    }

}