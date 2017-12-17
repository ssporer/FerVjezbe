package hr.fer.java.vjezbe.zadatak7.web;

import hr.fer.java.vjezbe.zadatak7.model.*;
import hr.fer.java.vjezbe.zadatak7.service.BookService;
import hr.fer.java.vjezbe.zadatak7.service.CheckoutService;
import hr.fer.java.vjezbe.zadatak7.service.LibrarianService;
import hr.fer.java.vjezbe.zadatak7.service.MemberService;
import org.hibernate.annotations.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("/api") @CrossOrigin("*") public class AngularController {

    private static final Logger log = LoggerFactory.getLogger(AngularController.class);

    @Autowired private BookService bookService;

    @Autowired private MemberService memberService;

    @Autowired private LibrarianService librarianService;

    @Autowired private CheckoutService checkoutService;

    @GetMapping("/index") public RestDto<Void> index() {
        return RestDto.success("Success");
    }

    @GetMapping("/books") public RestDto<List<String>> books() {
        return RestDto.success(bookService.getAllAvailableTitles(), "Sve knjige");
    }

    @GetMapping("/members") RestDto<List<MemberDto>> members() {
        return RestDto.success(memberService.getAllMembers(), "Svi clanovi");
    }

    @GetMapping("/librarians") public RestDto<List<LibrarianDto>> librarians() {
        return RestDto.success(librarianService.getAllLibrarians(), "Svi knjiznicari");
    }

    @GetMapping("/checkouts") public RestDto<List<CheckoutDto>> checkouts() {
        return RestDto.success(checkoutService.getAllCheckouts(), "Success");
    }

    @PostMapping("/checkout") public RestDto<Void> checkout(@RequestBody @Valid CheckoutDto checkoutDto) {
        checkoutService.checkout(checkoutDto);
        return RestDto.success("Iznamljeno");
    }

    @PostMapping("/checkin") public RestDto<Void> checkin(@RequestBody CheckoutDto checkoutDto) {
        checkoutService.checkIn(checkoutDto);
        return RestDto.success("Vračeno");
    }

    @PostMapping("/delete") public RestDto<Void> delete(@RequestBody CheckoutDto checkoutDto) {
        checkoutService.delete(checkoutDto);
        return RestDto.success("Obrisano");
    }
}
