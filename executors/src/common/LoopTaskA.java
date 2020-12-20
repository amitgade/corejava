package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 20-Dec-2020
 */
public class LoopTaskA implements Runnable {

    private static int count = 0;
    private int id = 0;

    public LoopTaskA() {
        this.id = ++count;
    }

    @Override
    public void run() {

        System.out.println("#### <TASK-" + id + "> STARTING ####");

        for (int i = 10; i > 0; i--) {
            System.out.println("<" + id + "> TICK-TICK - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("#### <TASK-" + id + "> COMPLETED ####");
    }
}
