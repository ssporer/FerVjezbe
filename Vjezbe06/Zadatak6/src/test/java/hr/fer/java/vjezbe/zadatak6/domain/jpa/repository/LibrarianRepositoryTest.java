package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.LibrarianEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibrarianRepositoryTest {

    @Autowired private LibrarianRepository repository;

    @Test
    @Transactional
    public void rwTest() {

        String firstName = "Ime";
        String lastName = "prezime";
        String username = "iprezime";

        LibrarianEntity librarian = new LibrarianEntity();
        librarian.setUsername(username);
        librarian.setFirstName(firstName);
        librarian.setLastName(lastName);

        LibrarianEntity savedLibrarian = repository.save(librarian);

        assertNotNull(savedLibrarian);
        assertNotNull(savedLibrarian.getId());

        LibrarianEntity loadedLibrarian = repository.findOne(savedLibrarian.getId());
        assertNotNull(loadedLibrarian);
        assertEquals(firstName, loadedLibrarian.getFirstName());
        assertEquals(lastName, loadedLibrarian.getLastName());
        assertEquals(username, loadedLibrarian.getUsername());
    }

}
