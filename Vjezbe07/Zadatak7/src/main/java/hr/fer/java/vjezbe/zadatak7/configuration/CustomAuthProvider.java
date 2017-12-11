package hr.fer.java.vjezbe.zadatak7.configuration;

import hr.fer.java.vjezbe.zadatak7.domain.LibrarianDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private LibrarianDao librarianDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication = librarianDao.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
