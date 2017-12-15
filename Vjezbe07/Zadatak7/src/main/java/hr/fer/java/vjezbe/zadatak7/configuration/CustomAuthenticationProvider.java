package hr.fer.java.vjezbe.zadatak7.configuration;

import hr.fer.java.vjezbe.zadatak7.domain.LibrarianDao;
import hr.fer.java.vjezbe.zadatak7.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired private LibrarianDao librarianDao;

    @Autowired private UserService userService;

    @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("Calling custom authentication");
        authentication = librarianDao.authenticateUser(authentication);
        userService.authenticateUser(authentication);
        return authentication;
    }

    @Override public boolean supports(Class<?> aClass) {
        return true;
    }
}
