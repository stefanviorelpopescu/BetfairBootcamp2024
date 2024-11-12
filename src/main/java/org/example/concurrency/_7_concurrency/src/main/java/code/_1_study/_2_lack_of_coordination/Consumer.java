package org.example.concurrency._7_concurrency.src.main.java.code._1_study._2_lack_of_coordination;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Consumer extends Thread {

    private final IChannel channel;

    @Override
    public void run() {
        String previous = "0";
        String current = channel.take();
        while (!current.equals("DONE")) {
//            System.out.println(current);

            if (Integer.parseInt(current) != Integer.parseInt(previous) + 1) {
                System.out.println("lack of coordination");
                System.exit(0);
            }

            previous = current;
            current = channel.take();
        }
    }

}
