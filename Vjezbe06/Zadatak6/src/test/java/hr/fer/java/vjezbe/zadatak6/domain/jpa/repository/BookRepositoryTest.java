package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.AuthorEntity;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(BookRepositoryTest.class);

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    public void crudTest() {

        String title = "Title";
        String changedTitle = "Title2";
        String authorFirstName = "Ime";
        String authorLastName = "Prezime";

        // Create book
        BookEntity book = new BookEntity();
        book.setTitle(title);

        // Create author
        AuthorEntity author = new AuthorEntity();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);

        // Add author to book
        book.setAuthorByAuthorId(author);

        // Save book
        BookEntity savedBook = bookRepository.save(book);

        // Verify it is saved
        assertNotNull(savedBook);
        Integer id = savedBook.getId();
        assertNotNull(id);
        log.debug("Book saved under ID: {}", id);

        // Find saved book
        BookEntity readBook = bookRepository.findOne(id);

        // Verify it's the saved one
        assertNotNull(savedBook);
        log.debug("Read book: {}", readBook);
        assertEquals(title, readBook.getTitle());
        assertEquals(authorFirstName, readBook.getAuthorByAuthorId().getFirstName());
        assertEquals(authorLastName, readBook.getAuthorByAuthorId().getLastName());

        // Change the title
        readBook.setTitle(changedTitle);

        // Verify title was changed
        BookEntity updatedBook = bookRepository.findOne(savedBook.getId());
        assertNotNull(updatedBook);
        assertEquals(changedTitle, updatedBook.getTitle());
        log.debug("Updated book {}", updatedBook);

        // Delete the book
        bookRepository.delete(savedBook);

        // Verify it is gone
        assertNull(bookRepository.findOne(savedBook.getId()));
    }

}
