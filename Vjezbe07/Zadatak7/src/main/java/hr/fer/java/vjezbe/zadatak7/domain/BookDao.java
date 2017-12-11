package hr.fer.java.vjezbe.zadatak7.domain;

import hr.fer.java.vjezbe.zadatak7.model.BookDto;

import java.util.List;

public interface BookDao {

    List<BookDto> getAllBooks();

    List<String> getAvailableTitles();

    BookDto getAvailableBookByTitle(String title);

}
