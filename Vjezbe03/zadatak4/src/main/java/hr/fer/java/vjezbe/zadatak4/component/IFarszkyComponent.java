package hr.fer.java.vjezbe.zadatak4.component;

import org.springframework.stereotype.Component;

/**
 * Created by Igor Farszky on 30.10.2017..
 */
@Component
public class IFarszkyComponent extends CoreComponent {


    @Override
    public String setStudentName() {
        return "igor farszky";
    }
}
