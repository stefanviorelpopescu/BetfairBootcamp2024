package org.example.collections;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.comparingInt;

public class Main {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("1test");
        strings.add("2test2");
        strings.add("3test3");
//        for (String string : strings) {
//            System.out.println(string);
//            strings.remove(string);
//        }

        System.out.println(strings.size());

        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if (next.startsWith("2")) {
                iterator.remove();
            }
        }

        ListIterator<String> stringListIterator = strings.listIterator();
        while(stringListIterator.hasNext()) {
            String next = stringListIterator.next();
            stringListIterator.set("aaa");
        }

        List<String> list = strings.stream()
                .filter(s -> s.startsWith("2"))
                .toList();

        printSize(strings);

        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5.2);

        Map<String, Double> grades = new HashMap<>();
        Set<String> keys = grades.keySet();
        Collection<Double> values = grades.values();
        Set<Map.Entry<String, Double>> entries = grades.entrySet();

        Set<Months> spring = new HashSet<>(List.of(Months.MARCH, Months.APRIL, Months.MAY));
        EnumSet<Months> enumSpring = EnumSet.of(Months.MARCH, Months.APRIL, Months.MAY);

        Student ion = new Student("Ion", 7.5, 45);
        Student maria = new Student("Maria", 9.66, 20);
        Student dana = new Student("Dana", 9, 22);
        Student dana2 = new Student("Dana", 9, 25);

        Set<Student> students = new HashSet<>();
        students.add(ion);
        students.add(maria);
        students.add(dana);
        students.add(dana2);

        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("____________");

        TreeSet<Student> orderedStudents = new TreeSet<>();
        orderedStudents.add(ion);
        orderedStudents.add(maria);
        orderedStudents.add(dana);

        for (Student orderedStudent : orderedStudents) {
            System.out.println(orderedStudent);
        }

        TreeSet<Student> orderedStudentsByAge = new TreeSet<>(comparingDouble(Student::getGpa).reversed()
                .thenComparingInt(Student::getAge));
//        TreeSet<Student> orderedStudentsByAge = new TreeSet<>(new StudentComparatorByAge());
//        TreeSet<Student> orderedStudentsByAge = new TreeSet<>(comparingInt(Student::getAge));
        orderedStudentsByAge.add(ion);
        orderedStudentsByAge.add(maria);
        orderedStudentsByAge.add(dana);
        orderedStudentsByAge.add(dana2);

        for (Student orderedStudent : orderedStudentsByAge) {
            System.out.println(orderedStudent);
        }

        Map<String, Student> studentsByName = new HashMap<>();
        for (Student student : orderedStudentsByAge) {
            studentsByName.put(student.getName(), student);
        }
        System.out.println("________________________>>>");
        for (String name : studentsByName.keySet()) {
            System.out.println(studentsByName.get(name));
        }

        Map<Integer, List<Student>> studentsByAge = new HashMap<>();
//        for (Student student : orderedStudentsByAge) {
//            if (!studentsByAge.containsKey(student.getAge())) {
//                studentsByAge.put(student.getAge(), new ArrayList<>());
//            }
//            studentsByAge.get(student.getAge()).add(student);
//        }
        for (Student student : orderedStudentsByAge) {
            studentsByAge.computeIfAbsent(student.getAge(), age -> new ArrayList<>())
                    .add(student);
        }

        int sum = 0;

        orderedStudentsByAge.forEach(student -> studentsByAge.computeIfAbsent(student.getAge(), age -> new ArrayList<>())
                .add(student));
//        orderedStudentsByAge.forEach(student -> sum += student.getAge());

        for (Student student : orderedStudentsByAge) {
            studentsByAge.computeIfAbsent(student.getAge(), age -> new ArrayList<>())
                    .add(student);
            sum += student.getAge();
        }

        Map<Integer, List<Student>> collectByAge = orderedStudentsByAge.stream()
                .collect(Collectors.groupingBy(Student::getAge));

        Student [] studentsArray = new Student[] {ion, maria, dana};
//        printSizeStudent(List.of(studentsArray));
        printSizeStudent(new ArrayList<>(Arrays.asList(studentsArray)));
        printSizeStudent(Collections.emptyList());
        printSizeStudent(Collections.singletonList(dana));

    }

    public static double sumOfList(List<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void printSize(List<?> list) {
        System.out.println(list.size());
    }

    public static void printSizeStudent(List<Student> list) {
        System.out.println("printing");
        list.add(new Student("baubau", 5, 20));
        System.out.println(list.size());
    }


}
