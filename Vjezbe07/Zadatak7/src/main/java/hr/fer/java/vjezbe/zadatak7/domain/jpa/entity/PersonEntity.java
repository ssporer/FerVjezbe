package hr.fer.java.vjezbe.zadatak7.domain.jpa.entity;

import javax.persistence.*;

@Entity @Table(name = "PERSON", schema = "LIBRARY") public class PersonEntity {
    private Integer id;
    private String firstName;
    private String lastName;

    @Id @Column(name = "ID") @GeneratedValue(strategy=GenerationType.IDENTITY) public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic @Column(name = "FIRST_NAME") public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic @Column(name = "LAST_NAME") public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PersonEntity that = (PersonEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
            return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("First name: ").append(firstName);
        sb.append(System.lineSeparator());
        sb.append("Last name: ").append(lastName);
        return sb.toString();
    }
}
