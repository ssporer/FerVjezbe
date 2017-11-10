package hr.fer.java.vjezbe.zadatak4.component;

import hr.fer.java.vjezbe.zadatak4.model.RegisteredStudents;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public abstract class CoreComponent {

    protected abstract String setStudentName();

    @PostConstruct public void init() {
        RegisteredStudents.addStudent(setStudentName());
    }

}
