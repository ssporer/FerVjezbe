package hr.fer.java.vjezbe.zadatak07.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak07.domain.jpa.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    @Query("select author from AuthorEntity as author left outer join author.books book where book.title = :title")
    List<AuthorEntity> findByTitle(@Param("title") String title);

}
