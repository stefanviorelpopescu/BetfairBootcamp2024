package org.example.class_design.composition;

import org.example.class_design.composition.engine.Engine;

public class Vehicle {

    private Battery battery;
    private Engine engine;

    public Vehicle(Battery battery, Engine engine) {
        this.battery = battery;
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public void start() {
        battery.connect();
        engine.start();
    }

    public void start(long timeout) {

    }
}
