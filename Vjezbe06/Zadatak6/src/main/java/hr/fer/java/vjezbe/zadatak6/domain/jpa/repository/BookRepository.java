package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    @Query("select b from BookEntity as b where b.id not in (select book.id from BookEntity as book inner join book.checkouts c where c.checkoutTime is not null and c.checkinTime is null)")
    List<BookEntity> findAllAvailableBooks();

    @Query("select b.title from BookEntity as b where b.id not in (select book.id from BookEntity as book inner join book.checkouts c where c.checkoutTime is not null and c.checkinTime is null) group by b.title")
    List<String> findAllAvailableTitles();

    @Query("select b from BookEntity as b where b.title = :title and b.id not in (select book.id from BookEntity as book inner join book.checkouts c where c.checkoutTime is not null and c.checkinTime is null)")
    List<BookEntity> findAvailableByTitle(@Param("title") String title);

}
