package hr.fer.java.vjezbe.zadatak5.domain.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity @Table(name = "CHECKOUT", schema = "LIBRARY") public class CheckoutEntity {
    private Integer id;
    private Timestamp checkoutTime;
    private Timestamp checkinTime;
    private String user;
    private PersonEntity personByPersonId;
    private BookEntity bookByBookId;
    private LibrarianEntity librarianByLibrarianId;

    @Id @Column(name = "ID") public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic @Column(name = "CHECKOUT_TIME") public Timestamp getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Timestamp checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    @Basic @Column(name = "CHECKIN_TIME") public Timestamp getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Timestamp checkinTime) {
        this.checkinTime = checkinTime;
    }

    @Basic @Column(name = "USER") public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CheckoutEntity that = (CheckoutEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (checkoutTime != null ? !checkoutTime.equals(that.checkoutTime) : that.checkoutTime != null)
            return false;
        if (checkinTime != null ? !checkinTime.equals(that.checkinTime) : that.checkinTime != null)
            return false;
        if (user != null ? !user.equals(that.user) : that.user != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (checkoutTime != null ? checkoutTime.hashCode() : 0);
        result = 31 * result + (checkinTime != null ? checkinTime.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @ManyToOne @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID", nullable = false)
    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID", nullable = false)
    public PersonEntity getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(PersonEntity personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    @ManyToOne @JoinColumn(name = "LIBRARIAN_ID", referencedColumnName = "ID", nullable = false)
    public LibrarianEntity getLibrarianByLibrarianId() {
        return librarianByLibrarianId;
    }

    public void setLibrarianByLibrarianId(LibrarianEntity librarianByLibrarianId) {
        this.librarianByLibrarianId = librarianByLibrarianId;
    }
}
