package hr.fer.java.vjezbe.zadatak6.service;

import hr.fer.java.vjezbe.zadatak6.domain.BookDao;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<String> getAllAvailableTitles() {
        return bookDao.getAvailableTitles();
    }
}
