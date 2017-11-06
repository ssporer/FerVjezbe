package hr.fer.java.vjezbe.zadatak4.controller;

import hr.fer.java.vjezbe.zadatak4.component.CoreComponent;
import hr.fer.java.vjezbe.zadatak4.component.IFarszkyComponent;
import hr.fer.java.vjezbe.zadatak4.model.RegisteredStudents;
import hr.fer.java.vjezbe.zadatak4.model.enums.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/") public class MainController {

    @GetMapping({"/", "/registered"}) public String displayRegistered() {
        return display(RegisteredStudents.getRegistered());
    }

    @GetMapping("/valid") public String displayValidResult() {
        return display(RegisteredStudents.contains(Students.toList()));
    }

    @GetMapping("/invalid") public String displayInvalidResult() {
        return display(RegisteredStudents.missing(Students.toList()));
    }

    private String display(List<String> studentList) {
        return String.join(",<br/>", studentList);
    }
}
