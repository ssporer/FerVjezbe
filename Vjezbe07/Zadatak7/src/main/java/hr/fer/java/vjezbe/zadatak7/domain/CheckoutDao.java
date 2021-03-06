package hr.fer.java.vjezbe.zadatak7.domain;

import hr.fer.java.vjezbe.zadatak7.model.CheckoutDto;

import java.util.List;

public interface CheckoutDao {

    void checkout(CheckoutDto checkoutDto);

    void checkIn(CheckoutDto checkoutDto);

    List<CheckoutDto> getAllCheckouts();

    void delete(CheckoutDto dto);
}
