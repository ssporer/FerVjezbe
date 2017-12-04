package hr.fer.java.vjezbe.zadatak6.domain.jpa;

import hr.fer.java.vjezbe.zadatak6.domain.LibrarianDao;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.LibrarianRepository;
import hr.fer.java.vjezbe.zadatak6.model.BookDto;
import hr.fer.java.vjezbe.zadatak6.model.LibrarianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository @Transactional public class LibrarianJpaImpl implements LibrarianDao {

    private final LibrarianRepository repository;

    @Autowired public LibrarianJpaImpl(LibrarianRepository repository) {
        this.repository = repository;
    }

    @Override public List<LibrarianDto> findAll() {
        return repository.findAll().stream().map(LibrarianDto::new).collect(Collectors.toList());
    }

    @Override public LibrarianDto findByUsername(String username) {
        return new LibrarianDto(repository.findByUsername(username));
    }
}
