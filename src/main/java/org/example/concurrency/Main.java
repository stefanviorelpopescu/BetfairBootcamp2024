package org.example.concurrency;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        Integer n1 = Integer.valueOf(7);
        Integer n2 = 777;
        System.out.println("Before: " + n2);
        incrementNumber(n2);
        System.out.println("After: " + n2);


        n2 += 2;

        System.out.println(n1 == n2);

        System.out.println("Main start");

//        Thread t1 = new MyThread1();
//        t1.start();

        MyThread2 r1 = new MyThread2("");
        Thread t2 = new Thread(r1);
        t2.start();

        t2.join();
        System.out.println(r1.getResult());

//        t1.join();

        Callable<String> c1 = new MyCallable();
//        String call = c1.call();
//        System.out.println(call);

        System.out.println("Main end");

//        counterExample();

        ThreadPoolExecutor myExecutor = new ThreadPoolExecutor(2,
                8,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy());
        try (myExecutor) {
            for (int i = 0; i < 10; i++) {
                myExecutor.execute(new MyThread2(""));
            }
        }
    }

    @SneakyThrows
    private static void counterExample() {
        Counter counter = new Counter();

        List<Thread> threads = new ArrayList<>();
        List<Thread> synchronizedList = Collections.synchronizedList(threads);

        for (int i = 0; i < 1_00; i++) {
            threads.add(new Thread(new CounterIncrementer(counter)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(counter.getCount());
        System.out.println(counter.getSecondCount());
    }

    private static void incrementNumber(Integer number) {
        number += 3;
        System.out.println(number);
    }

}
