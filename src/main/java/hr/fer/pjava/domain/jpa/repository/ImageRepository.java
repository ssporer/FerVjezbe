package hr.fer.pjava.domain.jpa.repository;

import hr.fer.pjava.domain.jpa.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("SELECT i FROM Image i WHERE i.title = ?1 ORDER BY i.uploadDate DESC")
    public Image findLastByTitle(String filename);

}
