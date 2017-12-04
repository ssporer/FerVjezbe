package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.LibrarianEntity;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.PersonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired private PersonRepository repository;

    @Test
    @Transactional
    public void rwTest() {

        String firstName = "Ime";
        String lastName = "prezime";

        PersonEntity person = new PersonEntity();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        PersonEntity savedPerson = repository.save(person);

        assertNotNull(savedPerson);
        assertNotNull(savedPerson.getId());

        PersonEntity loadedPerson = repository.findOne(savedPerson.getId());
        assertNotNull(loadedPerson);
        assertEquals(firstName, loadedPerson.getFirstName());
        assertEquals(lastName, loadedPerson.getLastName());
    }

}
