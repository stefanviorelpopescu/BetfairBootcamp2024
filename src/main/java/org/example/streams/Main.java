package org.example.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Student ion = new Student("Ion", 7.5, 45);
        Student maria = new Student("Maria", 9.66, 20);
        Student dana = new Student("Dana", 9, 22);
        Student dana2 = new Student("Dana", 9, 25);

        List<Student> students = new ArrayList<>();
        students.add(ion);
        students.add(maria);
        students.add(dana);
        students.add(dana2);

        students.forEach(System.out::println);
        students.removeIf(student -> student.getName().startsWith("X"));

        double asDouble = students.stream()
                .filter(student -> student.getAge() == 22)
                .mapToDouble(Student::getGpa)
                .max()
                .orElse(0);

        Optional<Student> studentById = getById(15);
        if (studentById.isEmpty()) {
            throw new RuntimeException();
        }
        Student student = studentById.get();

        int id = 15;
        Student sss = getById(id)
                .orElseThrow(() -> new RuntimeException("Could not find student with id=" + id));

        studentById.ifPresent(System.out::println);

        students.stream()
                .map(Student::getGpa)
                .forEach(System.out::println);

        List<Double> list1 = students.stream()
                .map(Student::getGpa)
                .filter(gpa -> gpa == 22)
                .toList();

        Double sum = students.stream()
                .distinct()
                .sorted(Comparator.comparingLong(Student::getAge).reversed())
                .limit(56)

                .filter(student1 -> student1.getAge() == 22)
                .map(Student::getGpa)
                .reduce(0d, Double::max);
//                .toList();

        Optional<Student> any = students.stream()
                .filter(student1 -> student1.getAge() == 22)
                .findAny();

        Map<Integer, List<Student>> collect = students.stream()
                .filter(student1 -> student1.getAge() == 22)
                .collect(Collectors.groupingBy(Student::getAge));

        Map<String, Student> collect2 = students.stream()
                .filter(student1 -> student1.getAge() == 22)
                .collect(Collectors.toMap(Student::getName, Function.identity()));

    }

    public static Optional<Student> getById(long id) {
        Student ion = new Student("Ion", 7.5, 45);
        return Optional.ofNullable(ion);
    }
}
