package hr.fer.java.vjezbe.zadatak4.component;

import org.springframework.stereotype.Component;

/**
 * Created by Mislav on 30.10.2017..
 */
@Component
public class MislavComponent extends CoreComponent {
    @Override
    protected String setStudentName(){
        return "Mislav";
    }
}
