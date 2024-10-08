package org.example.class_design.composition.engine;

@FunctionalInterface
public interface Engine {

    default void start() {
        System.out.println("default start");
    }
    void stop();

}
