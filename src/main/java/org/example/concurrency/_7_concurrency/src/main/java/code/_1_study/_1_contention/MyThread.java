package org.example.concurrency._7_concurrency.src.main.java.code._1_study._1_contention;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 1_000_000; i++) {
            synchronized (MyThread.class) {
                ContentionExample.v++;
            }
        }
    }

    private static synchronized void incrementCounter() {
            ContentionExample.v++;
    }
}