package hr.fer.java.vjezbe.zadatak7.web;

import hr.fer.java.vjezbe.zadatak7.model.RestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice public class MainControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MainControllerAdvice.class);

    @ResponseStatus(HttpStatus.OK) @ExceptionHandler(Exception.class)
    public RestDto<Void> handleGenericException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return RestDto.fail("Greška na serveru: " + ex.getMessage());
    }

}
