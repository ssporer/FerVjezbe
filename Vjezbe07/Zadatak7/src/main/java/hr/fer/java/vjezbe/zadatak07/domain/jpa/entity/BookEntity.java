package hr.fer.java.vjezbe.zadatak07.domain.jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "BOOK", schema = "LIBRARY") public class BookEntity {
    private Integer id;
    private String title;
    private AuthorEntity authorByAuthorId;
    private Set<CheckoutEntity> checkouts;

    @Id @Column(name = "ID") @GeneratedValue(strategy = GenerationType.IDENTITY) public Integer getId() {
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

    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID") public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @OneToMany(mappedBy = "bookByBookId", cascade = CascadeType.ALL)
    public Set<CheckoutEntity> getCheckouts() {
        return checkouts;
    }

    public void setCheckouts(Set<CheckoutEntity> checkouts) {
        this.checkouts = checkouts;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("ID: ").append(id);
        sb.append(System.lineSeparator());
        sb.append("Title: ").append(title);
        sb.append(System.lineSeparator());
        sb.append("Author: ").append(authorByAuthorId);
        return sb.toString();
    }
}
