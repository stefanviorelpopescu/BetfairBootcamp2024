package org.example._3_design_patterns.src.main.java.code._2_challenge._6_builder;

public class BuilderExample {

    public static void main(String[] args) {

        Person person01 = new Person.Builder("Popescu")
                .job("java developer")
                .university("FMI")
                .isMarried(false)
                .build();

        String oldName = "Ion";

        Person person02 = new Person.Builder("Ionescu")
                .drivingLicense("B")
                .isMarried(true)
                .build();

        PersonLombok test = PersonLombok.builder()
                .name("test")
                .isMarried(true)
                .build();

        StringBuilder name = new StringBuilder("Ion");

        name.append(" Popescu");

        for (int i = 0; i < 1_000_000; i++) {
            name.append("test");
        }
        System.out.println("done");
    }
}
