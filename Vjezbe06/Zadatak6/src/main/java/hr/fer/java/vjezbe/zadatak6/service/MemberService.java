package hr.fer.java.vjezbe.zadatak6.service;

import hr.fer.java.vjezbe.zadatak6.domain.MemberDao;
import hr.fer.java.vjezbe.zadatak6.model.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public List<MemberDto> getAllMembers() {
        return memberDao.findAll();
    }
}
