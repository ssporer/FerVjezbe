package hr.fer.java.vjezbe.zadatak6.domain.jpa;

import hr.fer.java.vjezbe.zadatak6.domain.BookDao;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.BookRepository;
import hr.fer.java.vjezbe.zadatak6.model.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository @Transactional public class BookJpaImpl implements BookDao {

    private static final Logger log = LoggerFactory.getLogger(BookJpaImpl.class);

    private final BookRepository repository;

    @Autowired public BookJpaImpl(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @Override public List<BookDto> getAllBooks() {
        return repository.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @Override public List<String> getAvailableTitles() {
        return repository.findAllAvailableTitles();
    }

    @Override public BookDto getAvailableBookByTitle(String title) {
        return new BookDto(repository.findAvailableByTitle(title).get(0));
    }

}
