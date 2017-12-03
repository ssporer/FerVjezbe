package hr.fer.java.vjezbe.zadatak6.model;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.BookEntity;

public class BookDto {

    private Integer id;

    private String authorFirstName;

    private String authorLastName;

    private String title;

    public BookDto() {

    }

    public BookDto(BookEntity bookEntity) {
        if (bookEntity == null)
            return;

        this.id = bookEntity.getId();

        if (bookEntity.getAuthorByAuthorId() != null) {
            this.authorFirstName = bookEntity.getAuthorByAuthorId().getFirstName();
            this.authorLastName = bookEntity.getAuthorByAuthorId().getLastName();
        }

        this.title = bookEntity.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        sb.append(authorFirstName).append(" ");
        sb.append(authorLastName).append(": ");
        sb.append(title);
        return sb.toString();
    }
}
