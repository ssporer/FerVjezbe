package hr.fer.java.vjezbe.zadatak5.domain.jpa;

import hr.fer.java.vjezbe.zadatak5.domain.CheckoutsDao;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.repository.BookRepository;
import hr.fer.java.vjezbe.zadatak5.domain.jpa.repository.CheckoutRepository;
import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Mislav on 13.11.2017..
 */
@Repository
@Transactional
public class CheckoutsJpaImpl implements CheckoutsDao {

    private static final Logger log = LoggerFactory.getLogger(CheckoutsJpaImpl.class);

    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutsJpaImpl(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }
    @Override
    public List<CheckoutDto> getAllCheckouts() {
        return checkoutRepository.findAll().stream().map(ce -> new CheckoutDto(ce)).collect(Collectors.toList());
    }
}
