package hr.fer.java.vjezbe.zadatak7.web;

import hr.fer.java.vjezbe.zadatak7.model.RestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AngularController {

    @GetMapping("/index")
    public RestDto<Void> index() {
        return RestDto.success("Success");
    }

}
