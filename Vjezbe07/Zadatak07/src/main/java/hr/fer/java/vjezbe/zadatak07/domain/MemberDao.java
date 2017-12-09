package hr.fer.java.vjezbe.zadatak07.domain;

import hr.fer.java.vjezbe.zadatak07.model.MemberDto;

import java.util.List;

public interface MemberDao {

    List<MemberDto> findAll();

    MemberDto findById(Integer id);

}
