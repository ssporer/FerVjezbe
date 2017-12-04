package hr.fer.java.vjezbe.zadatak5.model;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.BookEntity;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.CheckoutEntity;

public class CheckoutDto {

    private String checkoutTime;
    private String checkinTime;
    private String user;
    private String personFirstName;
    private String personLastName;
    private String bookName;
    private String librarianFirstName;
    private String librarianLastName;

    public CheckoutDto(CheckoutEntity checkoutEntity) {
        if (checkoutEntity == null)
            return;

        if (checkoutEntity.getPersonByPersonId() != null) {
            this.personFirstName = checkoutEntity.getPersonByPersonId().getFirstName();
            this.personLastName = checkoutEntity.getPersonByPersonId().getLastName();
        }

        if (checkoutEntity.getLibrarianByLibrarianId() != null) {
            this.librarianFirstName = checkoutEntity.getPersonByPersonId().getFirstName();
            this.personLastName = checkoutEntity.getPersonByPersonId().getLastName();
        }

        this.title = bookEntity.getTitle();
    }
}
