package hr.fer.java.vjezbe.zadatak5.service;

import hr.fer.java.vjezbe.zadatak5.domain.CheckoutDao;
import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutsService {

    private final CheckoutDao checkoutJpaImpl;

    // private final BooksDao booksBatisImpl;

    @Autowired public CheckoutsService(CheckoutDao checkoutJpaImpl) {
        this.checkoutJpaImpl = checkoutJpaImpl;
    }

    public List<CheckoutDto> getCheckouts() {
        return checkoutJpaImpl.getAllCheckouts();
    }

}
