package hr.fer.java.vjezbe.zadatak6.web;

import hr.fer.java.vjezbe.zadatak6.model.CheckoutDto;
import hr.fer.java.vjezbe.zadatak6.service.BookService;
import hr.fer.java.vjezbe.zadatak6.service.CheckoutService;
import hr.fer.java.vjezbe.zadatak6.service.LibrarianService;
import hr.fer.java.vjezbe.zadatak6.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.Map;

@Controller public class MainController extends WebMvcConfigurerAdapter {

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

    @RequestMapping({"/", "/checkout"}) public String welcome(Map<String, Object> model) {
        model.put("checkoutDto", new CheckoutDto());
        fillModel(model);
        return "welcome";
    }

    @PostMapping("/checkout") public String checkout(Map<String, Object> model, @ModelAttribute @Valid CheckoutDto dto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            fillModel(model);
            return "welcome";
        }

        log.debug("form submit: {}", dto);
        checkoutService.checkout(dto);
        return "redirect:/";
    }

    private void fillModel(Map<String, Object> model) {
        model.put("titles", bookService.getAllAvailableTitles());
        model.put("members", memberService.getAllMembers());
        model.put("librarians", librarianService.getAllLibrarians());
        model.put("checkouts", checkoutService.getAllCheckouts());
    }

}
