package hr.fer.java.vjezbe.zadatak5.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mislav on 13.11.2017..
 */
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Integer> {
}
