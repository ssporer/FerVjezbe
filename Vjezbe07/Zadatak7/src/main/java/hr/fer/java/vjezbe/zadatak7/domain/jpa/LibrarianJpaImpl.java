package hr.fer.java.vjezbe.zadatak7.domain.jpa;

import hr.fer.java.vjezbe.zadatak7.domain.LibrarianDao;
import hr.fer.java.vjezbe.zadatak7.domain.jpa.entity.LibrarianEntity;
import hr.fer.java.vjezbe.zadatak7.domain.jpa.repository.LibrarianRepository;
import hr.fer.java.vjezbe.zadatak7.model.LibrarianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository @Transactional public class LibrarianJpaImpl implements LibrarianDao {

    private final LibrarianRepository repository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired public LibrarianJpaImpl(LibrarianRepository repository) {
        this.repository = repository;
    }

    @Override public List<LibrarianDto> findAll() {
        return repository.findAll().stream().map(LibrarianDto::new).collect(Collectors.toList());
    }

    @Override public LibrarianDto findByUsername(String username) {
        return new LibrarianDto(repository.findByUsername(username));
    }

    @Override
    public Authentication authenticate(Authentication auth) {
        LibrarianEntity librarian = repository.findByUsername(auth.getName());

        if(librarian == null) {
            throw new BadCredentialsException("Librarian not found!");
        }

        if(!encoder.matches(auth.getCredentials().toString(), librarian.getPassword())) {
            throw new BadCredentialsException("Wrong password!");
        }

        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(() -> "ROLE_LIBRARIAN");

        return new UsernamePasswordAuthenticationToken(librarian.getUsername(), librarian.getPassword(), auths);
    }
}
