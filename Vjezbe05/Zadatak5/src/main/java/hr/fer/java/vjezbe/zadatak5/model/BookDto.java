package hr.fer.java.vjezbe.zadatak5.model;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.BookEntity;

public class BookDto {

    private String authorFirstName;

    private String authorLastName;

    private String title;

    public BookDto() {
    }

    public BookDto(BookEntity bookEntity) {
        if (bookEntity == null)
            return;

        if (bookEntity.getAuthorByAuthorId() != null) {
            this.authorFirstName = bookEntity.getAuthorByAuthorId().getFirstName();
            this.authorLastName = bookEntity.getAuthorByAuthorId().getLastName();
        }

        this.title = bookEntity.getTitle();
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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.authorFirstName + " " + this.authorLastName;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getAuthor());
        sb.append(": ");
        sb.append(title);
        return sb.toString();
    }
}
