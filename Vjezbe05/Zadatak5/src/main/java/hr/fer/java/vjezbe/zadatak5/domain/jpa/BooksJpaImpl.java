package hr.fer.java.vjezbe.zadatak5.domain.jpa;

import hr.fer.java.vjezbe.zadatak5.domain.BooksDao;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.repository.BookRepository;
import hr.fer.java.vjezbe.zadatak5.model.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository @Transactional public class BooksJpaImpl implements BooksDao {

    private static final Logger log = LoggerFactory.getLogger(BooksJpaImpl.class);

    private final BookRepository bookRepository;

    @Autowired public BooksJpaImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookEntity -> new BookDto(bookEntity))
                .collect(Collectors.toList());
    }

    @Override public BookDto getBookByTitle(String title) {
        throw new RuntimeException("Not implemented");
    }

}
