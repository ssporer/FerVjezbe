package hr.fer.java.vjezbe.zadatak5.domain.jpa.entity;

import hr.fer.java.vjezbe.zadatak5.model.BookDto;

import javax.persistence.*;

@Entity @Table(name = "BOOK", schema = "LIBRARY") public class BookEntity {
    private Integer id;
    private String title;
    private AuthorEntity authorByAuthorId;

    @Id @Column(name = "ID") public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic @Column(name = "TITLE") public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BookEntity that = (BookEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @ManyToOne @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

}
