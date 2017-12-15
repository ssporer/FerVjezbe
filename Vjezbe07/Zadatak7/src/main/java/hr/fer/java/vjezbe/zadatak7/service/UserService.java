package hr.fer.java.vjezbe.zadatak7.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service public class UserService {

    public User getCurrentUser() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null && user instanceof User)
            return (User) user;
        return null;
    }

    public String getUsername() {
        User user = getCurrentUser();
        if (user != null)
            return user.getUsername();
        return null;
    }

    public List<String> getRoles() {
        User user = getCurrentUser();
        if (user != null)
            return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return new ArrayList<>();
    }

    public void authenticateUser(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
