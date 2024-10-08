package org.example.class_design;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TryResources {

    public static String PATH = "";

    public static void main(String[] args) throws FileNotFoundException {

        testResources();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(PATH));
        try (bufferedReader; bufferedReader2) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testResources() {
        List<Student> students = new ArrayList<>();

        try (StudentProcessor processor = new StudentProcessor()) {
            for (Student student : students) {
                processor.process(student);
            }

            for (int i = 0; i < students.size(); i++) {

            }

            for (int i = students.size() - 1; i >= 0; i--) {

            }

            students.forEach(processor::process);

        } catch (FileNotFoundException exception) {
            System.out.println("exception");
        }
    }
}
