package hr.fer.java.vjezbe.zadatak5.web;

import hr.fer.java.vjezbe.zadatak5.model.BookDto;
import hr.fer.java.vjezbe.zadatak5.service.BooksService;
import hr.fer.java.vjezbe.zadatak5.service.CheckoutsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController public class MainController {

    private final BooksService booksService;
    private final CheckoutsService checkoutsService;

    @Autowired public MainController(
    		BooksService booksService,
    		CheckoutsService checkoutsService) {
    	
        this.booksService = booksService;
        this.checkoutsService = checkoutsService;
    }

    @GetMapping("/") public String mainGet() {
        return "Hello zadatak 5";
    }

    @GetMapping("/books") public String booksGet() {
        return String.join("<br><br>",
                booksService.getBooks().stream().map(bookDto -> bookDto.toString()).collect(Collectors.toList()));
    }

    @GetMapping("/book/{title}") public String bookGetByTitle(@PathVariable(value = "title") String title) {
        BookDto bookDto = booksService.getBookByTitle(title);
        if (bookDto == null)
            return "No such book!";
        return bookDto.toString();
    }
    
    @GetMapping("/checkouts") public String checkouts() {
    	return String.join("<br><br>", checkoutsService.getCheckouts().stream()
    			.map(checkoutDto -> checkoutDto.toString()).collect(Collectors.toList()));
    }
}
