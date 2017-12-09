package hr.fer.java.vjezbe.zadatak07.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak07.domain.jpa.entity.LibrarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<LibrarianEntity, Integer> {

    LibrarianEntity findByUsername(String username);

}
