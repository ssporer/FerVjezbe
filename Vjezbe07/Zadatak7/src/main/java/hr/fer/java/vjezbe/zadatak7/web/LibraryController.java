package hr.fer.java.vjezbe.zadatak7.web;

import hr.fer.java.vjezbe.zadatak7.model.CheckoutDto;
import hr.fer.java.vjezbe.zadatak7.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller public class LibraryController {

    private static final Logger log = LoggerFactory.getLogger(LibraryController.class);

    private final BookService bookService;

    private final MemberService memberService;

    private final LibrarianService librarianService;

    private final CheckoutService checkoutService;

    private final UserService userService;

    @Autowired
    public LibraryController(BookService bookService, MemberService memberService, LibrarianService librarianService,
            CheckoutService checkoutService, UserService userService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.librarianService = librarianService;
        this.checkoutService = checkoutService;
        this.userService = userService;
    }

    @GetMapping({"/library", "/library/checkout", "/library/checkIn", "/library/deleteRecord"}) public String welcome(Model model) {
        return "redirect:/library/index";
    }

    @GetMapping("/library/index") public String index(Model model) {
        model.addAttribute("checkoutDto", new CheckoutDto());
        fillModel(model);
        return "library/index";
    }

    @PostMapping("/library/checkout") public String checkout(Model model, @Valid CheckoutDto dto, Errors errors) {

        if (errors.hasFieldErrors()) {
            fillModel(model);
            return "library/index";
        }

        log.debug("form submit: {}", dto);
        checkoutService.checkout(dto);
        return "redirect:/library/index";
    }

    @PostMapping("/library/checkIn") public String checkIn(CheckoutDto dto) {
        log.debug("form submit: {}", dto);
        checkoutService.checkIn(dto);
        return "redirect:/library/index";
    }

    @PostMapping("/library/deleteRecord") public String deleteRecort(CheckoutDto dto) {
        log.debug("delete form submit User:{} - Data : {}", userService.getUsername(), dto);
        checkoutService.delete(dto);
        return "redirect:/library/index";
    }

    private void fillModel(Model model) {
        model.addAttribute(userService.getCurrentUser());
        model.addAttribute("roles", userService.getRoles());
        model.addAttribute("titles", bookService.getAllAvailableTitles());
        model.addAttribute("members", memberService.getAllMembers());
        model.addAttribute("librarians", librarianService.getAllLibrarians());
        model.addAttribute("checkouts", checkoutService.getAllCheckouts());
    }
}
