package hr.fer.java.vjezbe.zadatak5.service;


import hr.fer.java.vjezbe.zadatak5.domain.BooksDao;
import hr.fer.java.vjezbe.zadatak5.domain.CheckoutsDao;
import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mislav on 13.11.2017..
 */
@Service
public class CheckoutService {
    private final CheckoutsDao checkoutsJpaImpl;

    @Autowired
    public CheckoutService(CheckoutsDao checkoutsJpaImpl) {
        this.checkoutsJpaImpl = checkoutsJpaImpl;
    }

    public List<CheckoutDto> getAllCheckouts(){
        return checkoutsJpaImpl.getAllCheckouts();
    }

}
