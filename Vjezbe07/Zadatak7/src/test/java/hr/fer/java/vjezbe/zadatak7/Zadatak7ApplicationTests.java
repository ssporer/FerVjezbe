package hr.fer.java.vjezbe.zadatak7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) @SpringBootTest public class Zadatak7ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Zadatak7ApplicationTests.class);

    private static final String PASSWORD = "1234";

    @Test public void generatePassword() {
        log.debug("***************************************************");
        log.debug("Password: {} :", PASSWORD);
        log.debug("---------------------------------------------------");
        log.debug("{}", new BCryptPasswordEncoder().encode(PASSWORD));
        log.debug("***************************************************");
    }

}
