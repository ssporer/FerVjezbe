package hr.fer.java.vjezbe.zadatak7.domain.jpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "AUTHORITIES", schema = "PUBLIC") public class AuthoritiesEntity {

    private String username;

    private String authority;

    private UsersEntity usersEntity;

    @Id @Column(name = "USERNAME") public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic @Column(name = "AUTHORITY") public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @ManyToOne @JoinColumn(name = "USERNAME", insertable=false, updatable=false) public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AuthoritiesEntity that = (AuthoritiesEntity) o;
        return Objects.equals(authority, that.authority);
    }

    @Override public int hashCode() {

        return Objects.hash(authority);
    }
}
