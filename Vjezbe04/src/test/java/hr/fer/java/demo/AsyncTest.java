package hr.fer.java.demo;

import hr.fer.java.demo.component.AsyncedTasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {

	@Test
	public void contextLoads() {
		for(int i = 0; i < 8; i++) {
			AsyncedTasks task3 = new AsyncedTasks();
			task3.sayHello();
		}
	}
}
