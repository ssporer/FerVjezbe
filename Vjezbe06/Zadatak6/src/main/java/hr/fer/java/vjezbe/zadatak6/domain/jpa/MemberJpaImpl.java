package hr.fer.java.vjezbe.zadatak6.domain.jpa;

import hr.fer.java.vjezbe.zadatak6.domain.MemberDao;
import hr.fer.java.vjezbe.zadatak6.domain.jpa.repository.PersonRepository;
import hr.fer.java.vjezbe.zadatak6.model.LibrarianDto;
import hr.fer.java.vjezbe.zadatak6.model.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository @Transactional public class MemberJpaImpl implements MemberDao {

    private final PersonRepository repository;

    @Autowired public MemberJpaImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override public List<MemberDto> findAll() {
        return repository.findAll().stream().map(memberEntity -> new MemberDto(memberEntity))
                .collect(Collectors.toList());
    }

    @Override public MemberDto findById(Integer id) {
        return new MemberDto(repository.findOne(id));
    }
}
