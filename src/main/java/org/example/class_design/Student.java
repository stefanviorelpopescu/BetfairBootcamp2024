package org.example.class_design;

import java.util.ArrayList;
import java.util.List;

public class Student
{
    String cnp;
    List<String> hobbies = new ArrayList<>();

    public Student(String cnp) {
        this.cnp = cnp;
    }

    public String getCnp() {
        return cnp;
    }

    public void addHobbies(List<String> hobbiesToAdd) {
        this.hobbies.addAll(hobbiesToAdd);
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}
