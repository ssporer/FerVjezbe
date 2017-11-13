package hr.fer.java.vjezbe.zadatak5.service;

import hr.fer.java.vjezbe.zadatak5.domain.BooksDao;
import hr.fer.java.vjezbe.zadatak5.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksDao booksJpaImpl;

    private final BooksDao booksBatisImpl;

    @Autowired public BooksService(BooksDao booksJpaImpl, BooksDao booksBatisImpl) {
        this.booksJpaImpl = booksJpaImpl;
        this.booksBatisImpl = booksBatisImpl;
    }

    public List<BookDto> getBooks() {
        return booksJpaImpl.getAllBooks();
    }

    public BookDto getBookByTitle(String title) {
        return booksBatisImpl.getBookByTitle(title);
    }

}
