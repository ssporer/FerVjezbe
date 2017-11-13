package hr.fer.java.vjezbe.zadatak5.domain.mybatis;

import hr.fer.java.vjezbe.zadatak5.domain.BooksDao;
import hr.fer.java.vjezbe.zadatak5.domain.mybatis.mapper.BooksMapper;
import hr.fer.java.vjezbe.zadatak5.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository @Transactional public class BooksBatisImpl implements BooksDao {

    private final BooksMapper booksMapper;

    @Autowired public BooksBatisImpl(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override public List<BookDto> getAllBooks() {
        throw new RuntimeException("Not implemented");
    }

    @Override public BookDto getBookByTitle(String title) {
        return booksMapper.getBookByTitle(title);
    }

}
