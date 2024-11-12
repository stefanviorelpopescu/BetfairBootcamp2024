package org.example.concurrency._7_concurrency.src.main.java.code._1_study._2_lack_of_coordination;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Producer extends Thread {

    private final IChannel channel;

    @Override
    public void run() {
        for (int i = 1; i <= 1_000_000_000; i++) {
            channel.put(String.valueOf(i));
        }
        channel.put("DONE");
    }
}
