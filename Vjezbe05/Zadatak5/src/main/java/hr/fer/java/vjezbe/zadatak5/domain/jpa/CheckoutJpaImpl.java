package hr.fer.java.vjezbe.zadatak5.domain.jpa;

import hr.fer.java.vjezbe.zadatak5.domain.CheckoutsDao;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.repository.CheckoutRepository;
import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository @Transactional public class CheckoutJpaImpl implements CheckoutsDao{
    private static final Logger log = LoggerFactory.getLogger(BooksJpaImpl.class);

    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutsJpaImpl(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    @Override public List<CheckoutDto> getAllCheckouts() {
        return checkoutRepository.findAll().stream().map(checkoutEntity -> new CheckoutDto(checkoutEntity))
                .collect(Collectors.toList());
    }
}
