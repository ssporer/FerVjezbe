package hr.fer.java.vjezbe.zadatak07.domain;

import hr.fer.java.vjezbe.zadatak07.model.LibrarianDto;

import java.util.List;

public interface LibrarianDao {

    List<LibrarianDto> findAll();

    LibrarianDto findByUsername(String username);
}
