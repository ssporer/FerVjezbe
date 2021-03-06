package hr.fer.java.vjezbe.zadatak4.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Students {

    PERE_MIKULIC,
    IFARSZKY,
    MISLAV,
    ZELBAR;

    public static List<String> toList() {
        return Arrays.stream(Students.values()).map(student -> student.toString()).collect(Collectors.toList());
    }

}
