package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    @Query("select b from BookEntity as b left outer join b.checkouts c where c.checkoutTime is null or c.checkinTime is not null")
    List<BookEntity> findAllAvailableBooks();

    @Query("select b.title from BookEntity as b left outer join b.checkouts c where c.checkoutTime is null or c.checkinTime is not null group by b.title")
    List<String> findAllAvailableTitles();

    @Query("select b from BookEntity as b left outer join b.checkouts c where b.title = :title and (c.checkoutTime is null or c.checkinTime is not null)")
    List<BookEntity> findAvailableByTitle(@Param("title") String title);

}
