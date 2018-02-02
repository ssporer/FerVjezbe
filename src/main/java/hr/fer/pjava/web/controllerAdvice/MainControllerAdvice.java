package hr.fer.pjava.web.controllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Igor Farszky on 2.2.2018..
 */
@ControllerAdvice
public class MainControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MainControllerAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleNotFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return "Server error: " + e.getMessage();
    }

}
