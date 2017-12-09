package hr.fer.java.vjezbe.zadatak07.web;

import hr.fer.java.vjezbe.zadatak07.model.CheckoutDto;
import hr.fer.java.vjezbe.zadatak07.service.BookService;
import hr.fer.java.vjezbe.zadatak07.service.CheckoutService;
import hr.fer.java.vjezbe.zadatak07.service.LibrarianService;
import hr.fer.java.vjezbe.zadatak07.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private final BookService bookService;

    private final MemberService memberService;

    private final LibrarianService librarianService;

    private final CheckoutService checkoutService;

    @Autowired
    public MainController(BookService bookService, MemberService memberService, LibrarianService librarianService,
            CheckoutService checkoutService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.librarianService = librarianService;
        this.checkoutService = checkoutService;
    }

    @GetMapping({"/", "/checkout", "/checkIn"}) public String welcome(Map<String, Object> model) {
        model.put("checkoutDto", new CheckoutDto());
        fillModel(model);
        return "welcome";
    }

    @PostMapping("/checkout") public String checkout(Map<String, Object> model, @Valid CheckoutDto dto, Errors errors) {

        if (errors.hasFieldErrors()) {
            fillModel(model);
            return "welcome";
        }

        log.debug("form submit: {}", dto);
        checkoutService.checkout(dto);
        return "redirect:/";
    }

    @PostMapping("/checkIn") public String checkIn(CheckoutDto dto) {
        log.debug("form submit: {}", dto);
        checkoutService.checkIn(dto);
        return "redirect:/";
    }

    private void fillModel(Map<String, Object> model) {
        model.put("titles", bookService.getAllAvailableTitles());
        model.put("members", memberService.getAllMembers());
        model.put("librarians", librarianService.getAllLibrarians());
        model.put("checkouts", checkoutService.getAllCheckouts());
    }

}
