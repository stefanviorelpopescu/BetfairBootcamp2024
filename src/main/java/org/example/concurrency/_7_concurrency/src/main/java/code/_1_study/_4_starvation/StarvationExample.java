package org.example.concurrency._7_concurrency.src.main.java.code._1_study._4_starvation;

public class StarvationExample {
    public static void main(String[] args) {
        OnePersonKitchen onePersonKitchen = new OnePersonKitchen();

        Person person1 = new Person("P1", onePersonKitchen);
        Person person2 = new Person("P2", onePersonKitchen);
        Person person3 = new Person("P3", onePersonKitchen);
        Person person4 = new Person("P4", onePersonKitchen);
        Person person5 = new Person("P5", onePersonKitchen);
        Person person6 = new Person("P6", onePersonKitchen);
        Person person7 = new Person("P7", onePersonKitchen);
        Person person8 = new Person("P8", onePersonKitchen);
        Person person9 = new Person("P9", onePersonKitchen);
        PersonThatNeverFinishesEating personThatNeverFinishesEating = new PersonThatNeverFinishesEating("P10", onePersonKitchen);

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();
        person8.start();
        person9.start();
        personThatNeverFinishesEating.start(); //if 10 never stops eating, and others cannot enter the kitchen to start eating => others will starve
    }
}
