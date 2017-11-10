package hr.fer.java.vjezbe.zadatak4.service;

import hr.fer.java.vjezbe.zadatak4.model.enums.Students;
import org.springframework.stereotype.Service;

/**
 * Created by Igor Farszky on 30.10.2017..
 */
@Service
public class IFarszkyService {

    public String getMyName() {
        return Students.IFARSZKY.toString();
    }

}
