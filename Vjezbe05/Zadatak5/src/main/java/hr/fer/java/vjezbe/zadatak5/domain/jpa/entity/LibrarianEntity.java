package hr.fer.java.vjezbe.zadatak5.domain.jpa.entity;

import javax.persistence.*;

@Entity @Table(name = "LIBRARIAN", schema = "LIBRARY") public class LibrarianEntity {
    private Integer id;
    private String firstName;
    private String lastName;

    @Id @Column(name = "ID") public Integer getId() {
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

        LibrarianEntity that = (LibrarianEntity) o;

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
}
