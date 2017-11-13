package hr.fer.java.vjezbe.zadatak5.domain;

import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;

import java.util.List;

public interface CheckoutDao {

    public List<CheckoutDto> getAllCheckouts();
}
