package hr.fer.java.vjezbe;

import hr.fer.java.vjezbe.component.impl.ThreadingUUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Igor Farszky on 6.11.2017..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadingTest extends Thread {

    private ThreadingUUID threadingUUID;

    @Autowired
    private void setThreadComponent() {
        this.threadingUUID = new ThreadingUUID();
    }

    @Override
    @Test
    public void run() {
        for (int i=0; i<8; i++) {
            try {
                threadingUUID.printThreadId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testThreading() {



    }

}
