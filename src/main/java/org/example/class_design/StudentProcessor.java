package org.example.class_design;

import java.io.FileNotFoundException;

public class StudentProcessor implements AutoCloseable{

    public StudentProcessor()  throws FileNotFoundException {
        if (1 != 1) {
            throw new FileNotFoundException();
        }
    }

    public void process(Student student) {
        System.out.println(student.hashCode());
    }

    public void close() {
        System.out.println("closing");
    }

}
