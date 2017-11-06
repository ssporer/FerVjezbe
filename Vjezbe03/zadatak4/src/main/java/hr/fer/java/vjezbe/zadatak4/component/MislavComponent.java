package hr.fer.java.vjezbe.zadatak4.component;

import hr.fer.java.vjezbe.zadatak4.model.enums.Students;
import org.springframework.stereotype.Component;

/**
 * Created by Mislav on 30.10.2017..
 */
@Component
public class MislavComponent extends CoreComponent {
    @Override
    protected String setStudentName(){
        return Students.MISLAV.toString();
    }
}
