package hr.fer.java.vjezbe.zadatak7.domain.jpa;

import hr.fer.java.vjezbe.zadatak7.domain.LibrarianDao;
import hr.fer.java.vjezbe.zadatak7.domain.jpa.entity.LibrarianEntity;
import hr.fer.java.vjezbe.zadatak7.domain.jpa.repository.LibrarianRepository;
import hr.fer.java.vjezbe.zadatak7.model.LibrarianDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Repository
@Transactional
public class LibrarianJpaImpl implements LibrarianDao {

    private static final Logger log = LoggerFactory.getLogger(LibrarianJpaImpl.class);

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final LibrarianRepository repository;

    @Autowired
    public LibrarianJpaImpl(LibrarianRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LibrarianDto> findAll() {
        return repository.findAll().stream().map(LibrarianDto::new).collect(Collectors.toList());
    }

    @Override
    public LibrarianDto findByUsername(String username) {
        return new LibrarianDto(repository.findByUsername(username));
    }

    @Override
    public Authentication authenticateUser(Authentication authentication) {
        LibrarianEntity librarian = repository.findByUsername(authentication.getName());
        if (librarian == null) {
            log.warn("Username not found");
            throw new BadCredentialsException("Username not found.");
        }

        if (!encoder.matches((String) authentication.getCredentials(), librarian.getPassword())) {
            log.warn("Wrong password");
            throw new BadCredentialsException("Wrong password.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> "ROLE_LIBRARIAN");

        return new UsernamePasswordAuthenticationToken(librarian.getUsername(),
                librarian.getPassword(), authorities);
    }
}
