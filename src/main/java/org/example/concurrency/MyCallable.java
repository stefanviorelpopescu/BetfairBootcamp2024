package org.example.concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(5_000);
        return "TEST";
    }
}
