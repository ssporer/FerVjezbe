package hr.fer.java.vjezbe.zadatak6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication public class Zadatak6Application {

    public static void main(String[] args) {
        SpringApplication.run(Zadatak6Application.class, args);
    }

}
