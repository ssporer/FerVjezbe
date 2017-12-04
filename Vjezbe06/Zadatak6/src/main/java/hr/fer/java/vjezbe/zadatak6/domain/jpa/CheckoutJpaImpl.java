package hr.fer.java.vjezbe.zadatak6.domain.jpa;

import hr.fer.java.vjezbe.zadatak6.domain.CheckoutDao;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.CheckoutEntity;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.BookRepository;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.CheckoutRepository;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.LibrarianRepository;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.PersonRepository;
import hr.fer.java.vjezbe.zadatak6.model.BookDto;
import hr.fer.java.vjezbe.zadatak6.model.CheckoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository @Transactional public class CheckoutJpaImpl implements CheckoutDao {

    private final CheckoutRepository repository;

    private final PersonRepository personRepository;

    private final BookRepository bookRepository;

    private final LibrarianRepository librarianRepository;

    @Autowired public CheckoutJpaImpl(CheckoutRepository repository, PersonRepository personRepository,
            BookRepository bookRepository, LibrarianRepository librarianRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
        this.librarianRepository = librarianRepository;
    }

    @Override public void checkout(CheckoutDto dto) {
        CheckoutEntity checkout = new CheckoutEntity();
        checkout.setPersonByPersonId(personRepository.findOne(dto.getMemberId()));
        checkout.setBookByBookId(bookRepository.findAvailableByTitle(dto.getBookTitle()).get(0));
        checkout.setLibrarianByLibrarianId(librarianRepository.findByUsername(dto.getLibrarianUsername()));
        checkout.setUser(dto.getLibrarianUsername());
        repository.save(checkout);
    }

    @Override public void checkIn(CheckoutDto dto) {
        CheckoutEntity checkout = repository
                .findByPersonByPersonIdIdAndBookByBookIdIdAndCheckinTimeNull(dto.getMemberId(), dto.getBookId());
        checkout.setLibrarianByLibrarianId(librarianRepository.findByUsername(dto.getLibrarianUsername()));
        checkout.setCheckinTime(new Timestamp(new Date().getTime()));
        checkout.setUser(dto.getLibrarianUsername());
    }

    @Override public List<CheckoutDto> getAllCheckouts() {
        return repository.findAll().stream().map(CheckoutDto::new).collect(Collectors.toList());
    }
}
