package org.example.concurrency._7_concurrency.src.main.java.code._1_study._4_starvation;

public class PersonThatNeverFinishesEating extends Person {
    public PersonThatNeverFinishesEating(String id, OnePersonKitchen onePersonKitchen) {
        super(id, onePersonKitchen);
    }

    @Override
    public void run() {
        synchronized (super.onePersonKitchen) {
            while (true) {
                System.out.println(super.id + " eating ...");
                super.onePersonKitchen.eat();
                //onePersonKitchen.notifyAll(); never notifies that the kitchen is free, will just continue eating ...
            }
        }
    }
}