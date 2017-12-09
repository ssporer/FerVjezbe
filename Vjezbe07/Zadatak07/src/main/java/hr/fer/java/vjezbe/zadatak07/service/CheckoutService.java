package hr.fer.java.vjezbe.zadatak07.service;

import hr.fer.java.vjezbe.zadatak07.domain.CheckoutDao;
import hr.fer.java.vjezbe.zadatak07.model.CheckoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class CheckoutService {

    private final CheckoutDao checkoutDao;

    @Autowired public CheckoutService(CheckoutDao checkoutDao) {
        this.checkoutDao = checkoutDao;
    }

    public void checkout(CheckoutDto dto) {
        checkoutDao.checkout(dto);
    }

    public void checkIn(CheckoutDto dto) {
        checkoutDao.checkIn(dto);
    }

    public List<CheckoutDto> getAllCheckouts() {
        return checkoutDao.getAllCheckouts();
    }
}
