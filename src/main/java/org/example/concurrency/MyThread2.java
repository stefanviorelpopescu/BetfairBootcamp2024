package org.example.concurrency;

import lombok.Getter;

@Getter
public class MyThread2 implements Runnable{

    String result;

    public MyThread2(String result) {
        this.result = result;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        result = "test";
//        System.out.println("This is a runnable");
    }
}
