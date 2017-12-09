package hr.fer.java.vjezbe.zadatak07.model;

import hr.fer.java.vjezbe.zadatak07.domain.jpa.entity.PersonEntity;

public class MemberDto {

    private Integer id;

    private String firstName;

    private String lastName;

    public MemberDto() {
    }

    public MemberDto(PersonEntity memberEntity) {
        if (memberEntity == null)
            return;
        this.id = memberEntity.getId();
        this.firstName = memberEntity.getFirstName();
        this.lastName = memberEntity.getLastName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
