package org.example.concurrency;

public class CounterIncrementer implements Runnable{

    private final Counter counter;

    public CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <1_000_000; i++) {
            counter.incrementSecondCounter();
        }
    }
}
