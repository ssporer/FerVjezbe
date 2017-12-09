package hr.fer.java.vjezbe.zadatak07.domain;

import hr.fer.java.vjezbe.zadatak07.model.BookDto;

import java.util.List;

public interface BookDao {

    List<BookDto> getAllBooks();

    List<String> getAvailableTitles();

    BookDto getAvailableBookByTitle(String title);

}
