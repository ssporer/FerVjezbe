package hr.fer.java.vjezbe.zadatak4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegisteredStudents {

    private static List<String> students = new ArrayList<>();

    public static void addStudent(String student) {
        students.add(student);
    }

    public static void removeStudent(String student) {
        students.remove(student);
    }

    public static List<String> getRegistered() {
        return students;
    }

    public static List<String> contains(List<String> values) {
        return values.stream().filter(student -> students.contains(student)).collect(Collectors.toList());
    }

    public static List<String> missing(List<String> values) {
        return values.stream().filter(student -> !students.contains(student)).collect(Collectors.toList());
    }
}
