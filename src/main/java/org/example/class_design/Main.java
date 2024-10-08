package org.example.class_design;

import org.example.class_design.composition.Battery;
import org.example.class_design.composition.MyBattery;
import org.example.class_design.composition.Vehicle;
import org.example.class_design.composition.engine.Engine;
import org.example.class_design.composition.engine.L4Engine;
import org.example.class_design.composition.engine.V6Engine;
import org.example.class_design.composition.engine.V8Engine;

import java.util.*;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {

        Battery battery = new MyBattery();
        Engine engine = new V8Engine();

        List<String> strings = new LinkedList<>();

        Vehicle vehicle = new Vehicle(battery, engine);
        vehicle.start();

        vehicle.setEngine(new V6Engine());

        Student s = null;
        System.out.println(s.equals(new Student("")));

        System.out.println("Hello world!");

        Student student = new Student("cnp");
        student.getCnp();

        Engine anonymousEngine = () -> System.out.println("test");

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        List<Student> students = new ArrayList<>();
        students.sort(Comparator.comparing(Student::getCnp));
        students.sort(Comparator.comparingInt(new ToIntFunction<Student>() {
            @Override
            public int applyAsInt(Student o) {
                return o.getHobbies().size();
            }
        }));

    }
}