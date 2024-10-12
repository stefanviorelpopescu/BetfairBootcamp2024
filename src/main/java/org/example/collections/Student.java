package org.example.collections;

import java.util.Objects;

public class Student implements Comparable<Student>{
    String name;
    double gpa;
    int age;

    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa, age);
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }
}
