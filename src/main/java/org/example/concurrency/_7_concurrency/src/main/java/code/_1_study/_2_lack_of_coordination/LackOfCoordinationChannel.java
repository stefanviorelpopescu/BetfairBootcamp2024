package org.example.concurrency._7_concurrency.src.main.java.code._1_study._2_lack_of_coordination;

public class LackOfCoordinationChannel implements IChannel {
    volatile String message = "";//write happens-before read
    volatile boolean isChannelEmpty = true;//write happens-before read

    public String take() {//may cause duplicated or missed reads
        while (isChannelEmpty) {
        }
        String container = message;
        isChannelEmpty = true;
        return container;
    }

    public void put(String message) {//writing 2 vars not in sync
        while (!isChannelEmpty) {
        }
        this.message = message;
        isChannelEmpty = false;
    }
}