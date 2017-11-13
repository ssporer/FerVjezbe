package hr.fer.java.vjezbe.zadatak5.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
