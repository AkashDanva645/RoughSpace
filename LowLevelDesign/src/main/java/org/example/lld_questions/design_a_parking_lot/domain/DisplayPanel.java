package org.example.lld_questions.design_a_parking_lot.external;

import lombok.Getter;

public class DisplayPanel implements Runnable {

    private int id;

    @Getter
    private int floorId;

    private String message;

    private boolean keepRunning = true;

    public void stop() {
        this.keepRunning = false;
    }

    public void changeMessage(String msg) {
        this.message = msg;
    }

    @Override
    public void run() {
        while (!keepRunning) {
            System.out.println(this.message);
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("ERROR: UNABLE TO STOP THE THREAD, " + e.getMessage());
            }
        }
    }
}
