package hr.fer.java.vjezbe.zadatak7.service;

import hr.fer.java.vjezbe.zadatak7.domain.CheckoutDao;
import hr.fer.java.vjezbe.zadatak7.model.CheckoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    @Secured("ROLE_ADMIN")
    public void delete(CheckoutDto dto) {
        checkoutDao.delete(dto);
    }
}
