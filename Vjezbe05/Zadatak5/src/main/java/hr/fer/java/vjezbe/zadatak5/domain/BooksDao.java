package hr.fer.java.vjezbe.zadatak5.domain;

import hr.fer.java.vjezbe.zadatak5.model.BookDto;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BooksDao {
    public List<BookDto> getAllBooks();

    public BookDto getBookByTitle(String title);
}
