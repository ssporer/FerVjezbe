package hr.fer.java.vjezbe.zadatak6.service.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String format(LocalDateTime localDateTime) {
        if (localDateTime == null)
            return null;
        return localDateTime.format(formatter);
    }
}
