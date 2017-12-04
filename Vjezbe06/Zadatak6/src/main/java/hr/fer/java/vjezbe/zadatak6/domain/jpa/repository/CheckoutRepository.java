package hr.fer.java.vjezbe.zadatak6.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.CheckoutEntity;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Integer> {

    CheckoutEntity findByPersonByPersonIdIdAndBookByBookIdIdAndCheckinTimeNull(Integer personId, Integer bookId);
}
