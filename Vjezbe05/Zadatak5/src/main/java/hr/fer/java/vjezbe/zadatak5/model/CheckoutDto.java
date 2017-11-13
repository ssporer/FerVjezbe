package hr.fer.java.vjezbe.zadatak5.model;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.CheckoutEntity;

import java.util.Date;
import java.sql.Timestamp;

public class CheckoutDto {

    private String personFirstName;
    private String personLastName;
    private String authorFirstName;
    private String authorLastName;
    private String librarianFirstName;
    private String librarianLastName;
    private String bookTitle;
    private Date checkoutTime;

    public CheckoutDto(CheckoutEntity checkoutEntity) {
        if (checkoutEntity == null)
            return;

        if(checkoutEntity.getPersonByPersonId() != null) {
            this.personFirstName = checkoutEntity.getPersonByPersonId().getFirstName();
            this.personLastName = checkoutEntity.getPersonByPersonId().getLastName();
        }

        if(checkoutEntity.getBookByBookId() != null) {
            this.bookTitle = checkoutEntity.getBookByBookId().getTitle();
        }

        if (checkoutEntity.getBookByBookId().getAuthorByAuthorId() != null) {
            this.authorFirstName = checkoutEntity.getBookByBookId().getAuthorByAuthorId().getFirstName();
            this.authorLastName = checkoutEntity.getBookByBookId().getAuthorByAuthorId().getLastName();
        }

        if (checkoutEntity.getLibrarianByLibrarianId() != null) {
            this.librarianFirstName = checkoutEntity.getLibrarianByLibrarianId().getFirstName();
            this.librarianLastName = checkoutEntity.getLibrarianByLibrarianId().getLastName();
        }

        if(checkoutEntity.getCheckoutTime() != null) {
            this.checkoutTime = checkoutEntity.getCheckoutTime();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(personFirstName).append(" ").append(personLastName).append(", ").append(authorFirstName).append(" ").append(authorLastName).append(", ").append(librarianFirstName).append(" ").append(librarianLastName).append(", ").append(checkoutTime).append(", ").append(bookTitle);

        return sb.toString();
    }
}
