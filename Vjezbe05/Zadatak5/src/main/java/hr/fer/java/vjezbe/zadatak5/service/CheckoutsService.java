package hr.fer.java.vjezbe.zadatak5.service;

import hr.fer.java.vjezbe.zadatak5.domain.CheckoutsDao;
import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CheckoutsService {
    private final CheckoutsDao checkoutsJpaImpl;

    @Autowired
    public CheckoutsService(CheckoutsDao booksJpaImpl) {
        this.checkoutsJpaImpl = booksJpaImpl;
    }

    public List<CheckoutDto> getBooks() {
        return checkoutsJpaImpl.getAllCheckouts();
    }

}
