package hr.fer.java.vjezbe.zadatak7;

import hr.fer.java.vjezbe.zadatak7.domain.jpa.entity.AuthoritiesEntity;
import hr.fer.java.vjezbe.zadatak7.domain.jpa.entity.LibrarianEntity;
import hr.fer.java.vjezbe.zadatak7.domain.jpa.repository.LibrarianRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class) @SpringBootTest public class Zadatak7ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Zadatak7ApplicationTests.class);

    @Autowired private LibrarianRepository librarianRepository;

    private static final String PASSWORD = "pass";

    @Test public void generatePassword() {
        log.debug("***************************************************");
        log.debug("Password: {} :", PASSWORD);
        log.debug("---------------------------------------------------");
        log.debug("{}", new BCryptPasswordEncoder().encode(PASSWORD));
        log.debug("***************************************************");
    }

    @Test @Transactional public void testUserLibrarian() {
        LibrarianEntity user = librarianRepository.findByUsername("rgiles");

        log.debug("first name {} ", user.getFirstName());
        log.debug("last name {} ", user.getLastName());
        log.debug("username {} ", user.getUsersEntity().getUsername());
        for (AuthoritiesEntity authority : user.getUsersEntity().getAuthoritiesEntities()) {
            log.debug("authority {} ", authority.getAuthority());
        }

    }

}
