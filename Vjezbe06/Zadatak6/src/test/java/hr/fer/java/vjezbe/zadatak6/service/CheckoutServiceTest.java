package hr.fer.java.vjezbe.zadatak6.service;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.*;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.BookRepository;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.CheckoutRepository;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.LibrarianRepository;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.PersonRepository;
import hr.fer.java.vjezbe.zadatak6.model.CheckoutDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) @SpringBootTest public class CheckoutServiceTest {

    @Autowired private CheckoutService checkoutService;

    @Autowired private CheckoutRepository checkoutRepository;

    @Autowired private BookRepository bookRepository;

    @Autowired private PersonRepository personRepository;

    @Autowired private LibrarianRepository librarianRepository;

    @Test @Transactional public void checkoutIn() throws Exception {
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
        book = bookRepository.save(book);
        assertNotNull(book);

        PersonEntity person = new PersonEntity();
        person.setFirstName(personFirstName);
        person.setLastName(personLastName);
        person = personRepository.save(person);
        assertNotNull(person);

        LibrarianEntity librarian = new LibrarianEntity();
        librarian.setUsername(librarianUsername);
        librarian.setFirstName(librarianFirstName);
        librarian.setLastName(librarianLastName);
        librarian = librarianRepository.save(librarian);
        assertNotNull(librarian);

        CheckoutDto checkoutDto = new CheckoutDto();
        checkoutDto.setBookTitle(bookTitle);
        checkoutDto.setMemberId(person.getId());
        checkoutDto.setLibrarianUsername(librarianUsername);

        checkoutService.checkout(checkoutDto);

        CheckoutEntity checkout = checkoutRepository
                .findByPersonByPersonIdIdAndBookByBookIdIdAndCheckinTimeNull(person.getId(), book.getId());

        assertNotNull(checkout);
        assertEquals(personFirstName, checkout.getPersonByPersonId().getFirstName());
        assertEquals(personLastName, checkout.getPersonByPersonId().getLastName());
        assertEquals(bookTitle, checkout.getBookByBookId().getTitle());
        assertEquals(authorFirstName, checkout.getBookByBookId().getAuthorByAuthorId().getFirstName());
        assertEquals(authorLastName, checkout.getBookByBookId().getAuthorByAuthorId().getLastName());
        assertEquals(librarianFirstName, checkout.getLibrarianByLibrarianId().getFirstName());
        assertEquals(librarianLastName, checkout.getLibrarianByLibrarianId().getLastName());
        assertEquals(librarianUsername, checkout.getLibrarianByLibrarianId().getUsername());
        assertNotNull(checkout.getCheckoutTime());
        assertNull(checkout.getCheckinTime());

        CheckoutDto checkIn = new CheckoutDto();
        checkIn.setMemberId(checkout.getPersonByPersonId().getId());
        checkIn.setBookId(checkout.getBookByBookId().getId());
        checkIn.setLibrarianUsername(checkout.getLibrarianByLibrarianId().getUsername());
        checkoutService.checkIn(checkIn);

        assertNull(checkoutRepository
                .findByPersonByPersonIdIdAndBookByBookIdIdAndCheckinTimeNull(person.getId(), book.getId()));
    }

}
