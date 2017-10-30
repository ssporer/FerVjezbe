package hr.fer.java.vjezbe.zadatak4.component;

import hr.fer.java.vjezbe.zadatak4.model.enums.Students;
import org.springframework.stereotype.Component;

/**
 * Created by Igor Farszky on 30.10.2017..
 */
@Component
public class IFarszkyComponent extends CoreComponent {


    @Override
    protected String setStudentName() {
        return Students.IFARSZKY.toString();
    }
}
