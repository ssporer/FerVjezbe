package hr.fer.java.vjezbe.zadatak5.model;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.CheckoutEntity;

import java.util.Date;

/**
 * Created by Mislav on 13.11.2017..
 */
public class CheckoutDto {
    private String bookTitle;
    private String authorFirstName;
    private String authorLastName;
    private Date checkoutTime;
    private Date checkinTime;
    private String librarianFirstName;
    private String librarianLastName;
    private String personFirstName;
    private String personLastName;

    public CheckoutDto(){}

    public CheckoutDto(CheckoutEntity checkoutEntity){
        if(checkoutEntity == null) return;

        BookDto book = new BookDto(checkoutEntity.getBookByBookId());

        if(book != null){
            this.bookTitle = book.getTitle();
            this.authorFirstName = book.getAuthorFirstName();
            this.authorLastName = book.getAuthorFirstName();
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
        this.checkinTime = checkoutEntity.getCheckinTime();

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(bookTitle).append(" ");
        sb.append(authorLastName).append(" ").append(authorFirstName).append(" | ");
        sb.append(personLastName).append(" ");
        sb.append(personFirstName).append(" ").append(" | ");
        sb.append(librarianLastName).append(" ");
        sb.append(librarianFirstName).append(" ").append(" | ");
        sb.append("CHECKOUT: ").append(checkoutTime);
        sb.append(" CHECKIN: ");

        if(checkinTime != null){
            sb.append(checkinTime);
        } else {
            sb.append("NIJE VRAĆENA");
        }
        return sb.toString();
    }

}
