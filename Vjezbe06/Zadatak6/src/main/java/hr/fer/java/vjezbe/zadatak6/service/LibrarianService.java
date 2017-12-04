package hr.fer.java.vjezbe.zadatak6.service;

import hr.fer.java.vjezbe.zadatak6.domain.LibrarianDao;
import hr.fer.java.vjezbe.zadatak6.model.LibrarianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    @Autowired private LibrarianDao librarianDao;

    public List<LibrarianDto> getAllLibrarians() {
        return librarianDao.findAll();
    }
}
