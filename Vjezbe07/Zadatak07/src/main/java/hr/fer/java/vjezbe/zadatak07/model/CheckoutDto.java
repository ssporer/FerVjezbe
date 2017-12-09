package hr.fer.java.vjezbe.zadatak07.model;

import hr.fer.java.vjezbe.zadatak07.domain.jpa.entity.*;
import hr.fer.java.vjezbe.zadatak07.service.util.LocalDateTimeUtil;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class CheckoutDto {

    @NotNull @Min(1) private Integer memberId;

    private String memberName;

    @NotNull @Size(min = 2) private String bookTitle;

    private Integer bookId;

    private String authorName;

    @NotNull @Size(min = 2) private String librarianUsername;

    private String librarianName;

    private LocalDateTime checkout;

    private LocalDateTime checkIn;

    public CheckoutDto() {
    }

    public CheckoutDto(CheckoutEntity entity) {
        if (entity == null)
            return;

        PersonEntity personEntity = entity.getPersonByPersonId();
        if (personEntity != null) {
            memberId = personEntity.getId();
            memberName = personEntity.getFirstName() + " " + personEntity.getLastName();
        }

        BookEntity bookEntity = entity.getBookByBookId();
        if (bookEntity != null) {
            bookId = bookEntity.getId();
            bookTitle = bookEntity.getTitle();
            AuthorEntity authorEntity = bookEntity.getAuthorByAuthorId();
            if (authorEntity != null) {
                authorName = authorEntity.getFirstName() + " " + authorEntity.getLastName();
            }
        }

        LibrarianEntity librarianEntity = entity.getLibrarianByLibrarianId();
        if (librarianEntity != null) {
            librarianUsername = librarianEntity.getUsername();
            librarianName = librarianEntity.getFirstName() + " " + librarianEntity.getLastName();
        }

        if (entity.getCheckoutTime() != null)
            checkout = entity.getCheckoutTime().toLocalDateTime();

        if (entity.getCheckinTime() != null)
            checkIn = entity.getCheckinTime().toLocalDateTime();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getLibrarianUsername() {
        return librarianUsername;
    }

    public void setLibrarianUsername(String librarianUsername) {
        this.librarianUsername = librarianUsername;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getCheckoutFormatted() {
        return LocalDateTimeUtil.format(checkout);
    }

    public String getCheckInFormatted() {
        return LocalDateTimeUtil.format(checkIn);
    }
}
