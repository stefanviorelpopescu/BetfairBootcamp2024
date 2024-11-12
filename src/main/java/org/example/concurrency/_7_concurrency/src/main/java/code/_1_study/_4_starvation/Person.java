package org.example.concurrency._7_concurrency.src.main.java.code._1_study._4_starvation;

import lombok.SneakyThrows;

public class Person extends Thread {
    protected final OnePersonKitchen onePersonKitchen;
    protected String id;

    public Person(String id, OnePersonKitchen onePersonKitchen) {
        super(id);
        this.id = id;
        this.onePersonKitchen = onePersonKitchen;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (onePersonKitchen) {
                System.out.println(id + " eating ...");
                onePersonKitchen.eat();
                System.out.println(id + " finished eating");
                onePersonKitchen.notifyAll(); //notify others that the kitchen is free now
                onePersonKitchen.wait();
            }
        }
    }

}