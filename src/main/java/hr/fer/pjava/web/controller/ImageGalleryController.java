package hr.fer.pjava.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor Farszky on 23.1.2018..
 */
@RestController
public class ImageGalleryController {

    @GetMapping("/")
    public String homePage() {
        return "image gallery home page";
    }

}
