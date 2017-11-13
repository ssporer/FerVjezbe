package hr.fer.java.vjezbe.zadatak5.web;

import hr.fer.java.vjezbe.zadatak5.model.CheckoutDto;
import hr.fer.java.vjezbe.zadatak5.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/checkouts")
    public String checkoutGet() {
        return String.join("<br><br>", checkoutService.getCheckouts().stream().map(CheckoutDto::toString).collect(Collectors.toList()));
    }
}
