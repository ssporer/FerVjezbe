package hr.fer.java.spring;

import hr.fer.java.spring.component.ThreadedComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldApplicationTests {

	@Autowired
	private ThreadedComponent threadedComponent;


	@Test
	public void asyncTest(){
		CountDownLatch cdl = new CountDownLatch(8);
		for(int i = 0; i < 8; i++) {
			try{
				threadedComponent.log(cdl);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
