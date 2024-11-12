package org.example.concurrency._7_concurrency.src.main.java.code._1_study._3_good_coordination;

public class Producer extends Thread {

    private IChannel channel;

    public Producer(IChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            channel.put(String.valueOf(i));
        }
        channel.put("DONE");
    }
}
