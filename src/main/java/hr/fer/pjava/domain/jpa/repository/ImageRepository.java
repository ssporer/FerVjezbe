package hr.fer.pjava.domain.jpa.repository;

import hr.fer.pjava.domain.jpa.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
