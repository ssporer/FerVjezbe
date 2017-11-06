package vjezbe4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vjezbe4.component.AsyncComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAsyncComponent {

    @Autowired
    AsyncComponent asyncComponent;

    @Test
    public void testAsyncComponent(){
        for(int i = 0; i<8; i++){
            asyncComponent.asyncMethodWithConfiguredExecutor(i);
        }
    }
}
