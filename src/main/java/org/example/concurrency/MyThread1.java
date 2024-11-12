package org.example.concurrency;

import lombok.SneakyThrows;

public class MyThread1 extends Thread{

    @SneakyThrows
    @Override
    public void run (){
        Thread.sleep(5_000);
        System.out.println("This is a Thread");
    }
}
