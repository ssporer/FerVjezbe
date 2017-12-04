package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.AuthorEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) @SpringBootTest public class AuthorRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(AuthorRepositoryTest.class);

    @Autowired private AuthorRepository repository;

    @Test
    @Transactional
    public void rwTest() {

        String firstName = "Ime";
        String lastName = "Prezime";

        AuthorEntity author = new AuthorEntity();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        AuthorEntity savedAuthor =  repository.save(author);

        assertNotNull(savedAuthor);
        assertNotNull(savedAuthor.getId());

        AuthorEntity loadAuthor = repository.findOne(savedAuthor.getId());

        assertNotNull(loadAuthor);
        assertEquals(firstName, loadAuthor.getFirstName());
        assertEquals(lastName, loadAuthor.getLastName());

    }

}
