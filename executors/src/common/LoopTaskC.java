package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 15-Aug-2020
 */
public class LoopTaskC implements Runnable {
    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public LoopTaskC() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskC" + instanceNumber;
    }

    @Override
    public void run() {

//        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### [" + Thread.currentThread().getName() + "] <" + taskId + "> STARTING ####");

        for (int i = 10; i > 0; i--) {
            System.out.println("[" + Thread.currentThread().getName() + "] <" + taskId + ">TICK TICK - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("**** [" + Thread.currentThread().getName() + "] <" + taskId + "> COMPLETED ****");
    }
}
