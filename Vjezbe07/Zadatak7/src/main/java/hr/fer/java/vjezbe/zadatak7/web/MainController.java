package hr.fer.java.vjezbe.zadatak7.web;

import hr.fer.java.vjezbe.zadatak7.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller public class MainController {

    @Autowired private UserService userService;

    @RequestMapping("/") public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index") public String index(Model model) {
        User user = userService.getCurrentUser();
        if (user != null)
            model.addAttribute(user);
        return "index";
    }

    @RequestMapping("/login") public String login() {
        return "login";
    }

    @RequestMapping("/login-error") public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
