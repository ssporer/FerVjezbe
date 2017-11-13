package hr.fer.java.vjezbe.zadatak5.domain;

import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;

import java.util.List;

/**
 * Created by Mislav on 13.11.2017..
 */
public interface CheckoutsDao {
    public List<CheckoutDto> getAllCheckouts();
}
