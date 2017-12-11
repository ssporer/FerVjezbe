package hr.fer.java.vjezbe.zadatak7.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak7.domain.jpa.entity.LibrarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;

public interface LibrarianRepository extends JpaRepository<LibrarianEntity, Integer> {

    LibrarianEntity findByUsername(String username);

}
