package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.*;
import hr.fer.java.vjezbe.zadatak6.model.LibrarianDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) @SpringBootTest public class CheckoutRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(CheckoutRepositoryTest.class);

    @Autowired private CheckoutRepository checkoutRepository;

    @Autowired private BookRepository bookRepository;

    @Autowired private PersonRepository personRepository;

    @Autowired private LibrarianRepository librarianRepository;

    @Test @Transactional public void crudTest() {

        String bookTitle = "Naslov";
        String authorFirstName = "Pisac";
        String authorLastName = "Prezime";
        String personFirstName = "Član";
        String personLastName = "Prezime";
        String librarianFirstName = "Knjižnjičar";
        String librarianLastName = "Prezime";
        String librarianUsername = "kprezime";


        BookEntity book = new BookEntity();
        book.setTitle(bookTitle);
        AuthorEntity author = new AuthorEntity();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthorByAuthorId(author);
        book = bookRepository.saveAndFlush(book);
        assertNotNull(book);

        PersonEntity person = new PersonEntity();
        person.setFirstName(personFirstName);
        person.setLastName(personLastName);
        person = personRepository.saveAndFlush(person);
        assertNotNull(person);

        LibrarianEntity librarian = new LibrarianEntity();
        librarian.setUsername(librarianUsername);
        librarian.setFirstName(librarianFirstName);
        librarian.setLastName(librarianLastName);
        librarian = librarianRepository.saveAndFlush(librarian);
        assertNotNull(librarian);

        assertEquals("Knjiga bi trebala biti raspoloziva", 1, bookRepository.findAvailableByTitle(bookTitle).size());

        CheckoutEntity checkout = new CheckoutEntity();
        checkout.setPersonByPersonId(person);
        checkout.setBookByBookId(book);
        checkout.setLibrarianByLibrarianId(librarian);
        checkout = checkoutRepository.saveAndFlush(checkout);
        assertNotNull(checkout);
        assertNotNull(checkout.getCheckoutTime());
        assertNull(checkout.getCheckinTime());

        assertEquals("Knjiga bi trebala biti posudjena",0,  bookRepository.findAvailableByTitle(bookTitle).size());

        checkout.setCheckinTime(new Timestamp(new Date().getTime()));

        CheckoutEntity checkIn = checkoutRepository.findOne(checkout.getId());
        assertNotNull(checkIn);
        assertNotNull(checkIn.getCheckoutTime());
        assertNotNull(checkIn.getCheckinTime());
        assertEquals(bookTitle, checkIn.getBookByBookId().getTitle());
        assertEquals(authorFirstName, checkIn.getBookByBookId().getAuthorByAuthorId().getFirstName());
        assertEquals(authorLastName, checkIn.getBookByBookId().getAuthorByAuthorId().getLastName());
        assertEquals(librarianFirstName, checkIn.getLibrarianByLibrarianId().getFirstName());
        assertEquals(librarianLastName, checkIn.getLibrarianByLibrarianId().getLastName());
        assertEquals(personFirstName, checkIn.getPersonByPersonId().getFirstName());
        assertEquals(personLastName, checkIn.getPersonByPersonId().getLastName());

        assertEquals("Knjiga bi trebala biti vracena", 1, bookRepository.findAvailableByTitle(bookTitle).size());

        checkoutRepository.delete(checkIn);
        assertNull(checkoutRepository.findOne(checkout.getId()));

        assertNotNull(bookRepository.findOne(book.getId()));
        assertNotNull(personRepository.findOne(person.getId()));
        assertNotNull(librarianRepository.findOne(librarian.getId()));
    }

}
