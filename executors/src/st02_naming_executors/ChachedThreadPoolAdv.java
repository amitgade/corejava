package st02_naming_executors;

import common.LoopTaskC;
import common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 20-Dec-2020
 */
public class ChachedThreadPoolAdv {
    public static void main(String[] args) throws InterruptedException {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("]" + currentThreadName + "[ Main thread starts ...");

        // name thread Pool by using ThreadFactory instance as constructor argument
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        for (int i = 0; i < 3; i++) {
            executorService.execute(new LoopTaskC());
        }

        // check that new tasks will reuse the threads 1/2/3 and crete 4/5 as new one
        // sleep 5 seconds is necessary to confirm previous running threads get completed
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Submitting more tasks now ...");

        for (int i = 0; i < 5; i++) {
            executorService.execute(new LoopTaskC());
        }

        executorService.shutdown();

        System.out.println("]" + currentThreadName + "[ Main thread starts ..." );


    }
}
