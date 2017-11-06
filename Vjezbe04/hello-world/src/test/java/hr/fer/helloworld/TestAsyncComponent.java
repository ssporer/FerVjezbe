package hr.fer.helloworld;

import hr.fer.helloworld.component.AsyncComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAsyncComponent {

    @Autowired
    AsyncComponent asyncComponent;

    @Test
    public void testAsyncComponent(){
        for(int i = 0; i<10; i++){
            asyncComponent.asyncMethodWithConfiguredExecutor(i);
        }
    }
}
