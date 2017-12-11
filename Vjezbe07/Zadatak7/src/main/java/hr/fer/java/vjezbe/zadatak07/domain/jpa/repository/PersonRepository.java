package hr.fer.java.vjezbe.zadatak07.domain.jpa.repository;

import hr.fer.java.vjezbe.zadatak07.domain.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
