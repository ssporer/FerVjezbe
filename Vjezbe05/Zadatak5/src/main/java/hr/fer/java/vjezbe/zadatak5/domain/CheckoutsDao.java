package hr.fer.java.vjezbe.zadatak5.domain;

import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;

import java.util.List;

public interface CheckoutsDao {

    public List<CheckoutDto> getAllCheckouts();
}
