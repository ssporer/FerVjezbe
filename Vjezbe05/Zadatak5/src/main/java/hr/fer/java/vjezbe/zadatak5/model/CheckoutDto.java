package hr.fer.java.vjezbe.zadatak5.model;

import java.sql.Timestamp;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.BookEntity;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.CheckoutEntity;

public class CheckoutDto {

    private String authorFirstName;

    private String authorLastName;

    private String bookTitle;
    
    private String personFirstName;
    
    private String personLastName;
    
    private String librarianFirstName;
    
    private String librarianLastName;
    
    private Timestamp checkinTime;
    
    private Timestamp checkoutTime;

    public CheckoutDto() {
    }

    public CheckoutDto(CheckoutEntity checkoutEntity) {
        this.bookTitle = checkoutEntity.getBookByBookId().getTitle();
        this.authorFirstName = checkoutEntity.getBookByBookId().getAuthorByAuthorId().getFirstName();
        this.authorLastName = checkoutEntity.getBookByBookId().getAuthorByAuthorId().getLastName();
        this.personFirstName = checkoutEntity.getPersonByPersonId().getFirstName();
        this.personLastName = checkoutEntity.getPersonByPersonId().getLastName();
        this.librarianFirstName = checkoutEntity.getLibrarianByLibrarianId().getFirstName();
        this.librarianLastName = checkoutEntity.getLibrarianByLibrarianId().getLastName();
        this.checkinTime = checkoutEntity.getCheckinTime();
        this.checkoutTime = checkoutEntity.getCheckoutTime();
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getTitle() {
        return bookTitle;
    }

    public void setTitle(String title) {
        this.bookTitle = title;
    }

    public String getAuthor() {
        return this.authorFirstName + " " + this.authorLastName;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(authorFirstName).append(" ");
        sb.append(authorLastName).append(": ");
        sb.append(bookTitle).append(" - ");
        sb.append(personFirstName).append(" ");
        sb.append(personLastName).append(": ");
        sb.append(checkinTime).append(" - ");
        sb.append(checkoutTime).append(". ");
        sb.append(librarianFirstName).append(" ");
        sb.append(librarianLastName);
        return sb.toString();
    }

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	public Time getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Time checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Time getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Time checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
}
