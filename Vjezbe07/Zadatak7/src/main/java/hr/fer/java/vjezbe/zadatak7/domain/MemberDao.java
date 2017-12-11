package hr.fer.java.vjezbe.zadatak7.domain;

import hr.fer.java.vjezbe.zadatak7.model.MemberDto;

import java.util.List;

public interface MemberDao {

    List<MemberDto> findAll();

    MemberDto findById(Integer id);

}
