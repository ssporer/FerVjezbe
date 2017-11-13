package hr.fer.java.vjezbe.zadatak5.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice public class MainControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MainControllerAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) @ExceptionHandler(Exception.class)
    public String handleNotFoundException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return "Server error: " + ex.getMessage();
    }

}
