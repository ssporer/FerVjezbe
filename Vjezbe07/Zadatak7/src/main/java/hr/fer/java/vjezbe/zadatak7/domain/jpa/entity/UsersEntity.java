package hr.fer.java.vjezbe.zadatak7.domain.jpa.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "USERS", schema = "PUBLIC") public class UsersEntity {
    private String username;
    private String password;
    private Boolean enabled;
    private List<AuthoritiesEntity> authoritiesEntities;

    @Id @Column(name = "USERNAME") public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic @Column(name = "PASSWORD") public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic @Column(name = "ENABLED") public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(mappedBy = "usersEntity")
    public List<AuthoritiesEntity> getAuthoritiesEntities() {
        return authoritiesEntities;
    }

    public void setAuthoritiesEntities(List<AuthoritiesEntity> authoritiesEntities) {
        this.authoritiesEntities = authoritiesEntities;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects
                .equals(enabled, that.enabled);
    }

    @Override public int hashCode() {

        return Objects.hash(username, password, enabled);
    }
}
