package hr.fer.java.vjezbe.zadatak4.controller;

import hr.fer.java.vjezbe.zadatak4.service.IFarszkyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor Farszky on 30.10.2017..
 */
@RestController
public class IFarszkyController {

    @Autowired
    private IFarszkyService iFarszkyService;

    @GetMapping("/ifarszky")
    public String getIfarszky() {
        return iFarszkyService.getMyName();
    }

}
