package org.example.concurrency;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class Counter {

    private long count = 0;
    private AtomicLong secondCount = new AtomicLong(0);

    private final Object lock = new Object();
    private final Object lock2 = new Object();

    public void incrementCounter() {
        synchronized (lock) {
            count++;
        }
    }

    public void incrementByTwo() {
        synchronized (lock) {
            for (int i = 0; i < 1; i++) {
                incrementCounter();
            }
        }
    }

    public void incrementSecondCounter() {
        secondCount.incrementAndGet();
    }

}
