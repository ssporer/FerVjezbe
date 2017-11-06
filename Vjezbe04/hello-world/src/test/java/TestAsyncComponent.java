import hr.fer.helloworld.component.AsyncComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
public class TestAsyncComponent {
    @Autowired
    private AsyncComponent asyncComponent;



    @Test
    public void testAsyncComponent(){
        for(int i = 0; i<10; i++){

        }
    }
}
