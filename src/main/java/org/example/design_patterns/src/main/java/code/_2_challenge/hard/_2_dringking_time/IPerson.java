package org.example.design_patterns.src.main.java.code._2_challenge.hard._2_dringking_time;

public interface IPerson {
    void walk();

    @LogExecutionTime
    void drink();

    String getName();
}