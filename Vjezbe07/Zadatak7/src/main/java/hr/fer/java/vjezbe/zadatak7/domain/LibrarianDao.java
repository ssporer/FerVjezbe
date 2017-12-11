package hr.fer.java.vjezbe.zadatak7.domain;

import hr.fer.java.vjezbe.zadatak7.model.LibrarianDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface LibrarianDao {

    List<LibrarianDto> findAll();

    LibrarianDto findByUsername(String username);

    Authentication authenticate(Authentication auth);
}
