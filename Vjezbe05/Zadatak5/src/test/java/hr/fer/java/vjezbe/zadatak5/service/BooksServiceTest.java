package hr.fer.java.vjezbe.zadatak5.service;

import hr.fer.java.vjezbe.zadatak5.model.BookDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksServiceTest {

    @Autowired
    private BooksService booksService;

    /**
     * JPA test
     * @throws Exception
     */
    @Test public void getBooks() throws Exception {

        // Only one book exists in liquibase script
        booksService.getBooks().stream().forEach(bookDto -> {
            assertEquals("KNJIGA1", bookDto.getTitle());
            assertEquals("PISAC1", bookDto.getAuthorFirstName());
            assertEquals("PREZIME", bookDto.getAuthorLastName());
        });
    }

    /**
     * Liquibase test
     * @throws Exception
     */
    @Test public void getBookByTitle() throws Exception {

        BookDto existingBook = booksService.getBookByTitle("KNJIGA1");
        assertNotNull(existingBook);
        assertEquals("KNJIGA1", existingBook.getTitle());
        assertEquals("PISAC1", existingBook.getAuthorFirstName());
        assertEquals("PREZIME", existingBook.getAuthorLastName());

        assertNull(booksService.getBookByTitle("KNJIGA2"));
    }

}
