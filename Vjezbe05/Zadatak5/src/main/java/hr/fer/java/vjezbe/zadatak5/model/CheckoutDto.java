package hr.fer.java.vjezbe.zadatak5.model;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.CheckoutEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class CheckoutDto {

    private String personFirstName;
    private String personLastName;
    private String authorFirstName;
    private String authorLastName;
    private String librarianFirstName;
    private String librarianLastName;
    private String bookTitle;
    private Date checkoutTime;

    public CheckoutDto(){

    }

    public CheckoutDto(CheckoutEntity checkoutEntity){
        if(checkoutEntity == null) return;

        if(checkoutEntity.getBookByBookId() != null){
            this.bookTitle = checkoutEntity.getBookByBookId().getTitle();

            if(checkoutEntity.getBookByBookId().getAuthorByAuthorId() != null){
                this.authorFirstName = checkoutEntity.getBookByBookId().getAuthorByAuthorId().getFirstName();
                this.authorLastName = checkoutEntity.getBookByBookId().getAuthorByAuthorId().getLastName();
            }
        }

        if(checkoutEntity.getPersonByPersonId() != null){
            this.personFirstName = checkoutEntity.getPersonByPersonId().getFirstName();
            this.personLastName = checkoutEntity.getPersonByPersonId().getLastName();
        }

        if(checkoutEntity.getLibrarianByLibrarianId() != null){
            this.librarianFirstName = checkoutEntity.getLibrarianByLibrarianId().getFirstName();
            this.librarianLastName = checkoutEntity.getLibrarianByLibrarianId().getLastName();
        }

        this.checkoutTime = checkoutEntity.getCheckoutTime();
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getLibrarianFirstName() {
        return librarianFirstName;
    }

    public String getLibrarianLastName() {
        return librarianLastName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(personFirstName).append(' ').append(personLastName).append(", ");
        sb.append(bookTitle).append(" - ").append(authorFirstName).append(' ').append(authorLastName).append(", ");
        sb.append(librarianFirstName).append(' ').append(librarianLastName).append(", ");
        sb.append(checkoutTime.toString());
        return sb.toString();
    }
}
