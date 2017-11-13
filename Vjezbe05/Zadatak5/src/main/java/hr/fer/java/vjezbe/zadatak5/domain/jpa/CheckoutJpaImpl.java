package hr.fer.java.vjezbe.zadatak5.domain.jpa;

import hr.fer.java.vjezbe.zadatak5.domain.CheckoutDao;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.entity.CheckoutEntity;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.repository.CheckoutRepository;
import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CheckoutJpaImpl implements CheckoutDao {

    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutJpaImpl(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    @Override
    public List<CheckoutDto> getAllCheckouts() {
        return checkoutRepository.findAll().stream().map(e -> new CheckoutDto(e)).collect(Collectors.toList());
    }
}
