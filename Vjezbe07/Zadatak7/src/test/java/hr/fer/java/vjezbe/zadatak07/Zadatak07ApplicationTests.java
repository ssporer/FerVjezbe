package hr.fer.java.vjezbe.zadatak07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) @SpringBootTest public class Zadatak07ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Zadatak07ApplicationTests.class);

    private static final String PASSWORD = "pass";

    @Test public void generatePassword() {
        log.debug("***************************************************");
        log.debug("Password: {} :", PASSWORD);
        log.debug("---------------------------------------------------");
        log.debug("{}", new BCryptPasswordEncoder().encode(PASSWORD));
        log.debug("***************************************************");
    }

}
