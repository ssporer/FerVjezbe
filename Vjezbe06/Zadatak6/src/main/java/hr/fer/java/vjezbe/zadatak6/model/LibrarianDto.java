package hr.fer.java.vjezbe.zadatak6.model;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.LibrarianEntity;

public class LibrarianDto {

    private Integer id;

    private String username;

    private String firstName;

    private String lastName;

    public LibrarianDto(){}

    public LibrarianDto(LibrarianEntity librarianEntity) {
        if (librarianEntity == null)
            return;
        this.id = librarianEntity.getId();
        this.username = librarianEntity.getUsername();
        this.firstName = librarianEntity.getFirstName();
        this.lastName = librarianEntity.getLastName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
