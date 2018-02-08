package hr.fer.pjava.domain.jpa.repository;

import hr.fer.pjava.domain.jpa.entity.KeyWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
public interface KeyWordsRepository extends JpaRepository<KeyWords, Long> {

    @Query("SELECT kw FROM KeyWords kw WHERE kw.image.id = ?1")
    List<KeyWords> findByImageId(Long imageId);

    @Query("SELECT kw FROM KeyWords kw WHERE upper(kw.keyWord) like concat('%', upper(?1), '%') ")
    List<KeyWords> findByKeyword(String keyword);

}
