package st01_creating_and_running_executors;

import common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by amit on 20-Dec-2020
 */
public class UsingFixedThreadPool {
    public static void main(String[] args) {
        System.out.println("Main thread starts");

        // Initialization - Create FixedThreadPool Executor service
        ExecutorService executorService = Executors.newFixedThreadPool(3); // at the most 3 concurrent threads

        // Service - Submit task(s) to the service using execute()
        for (int i = 0; i < 6; i++) {
            executorService.execute(new LoopTaskA());
        }

        // Destruction - call shutdown on service
        executorService.shutdown();

        // cannot submit task after service is shutdown - rejected execution exception
//        executorService.execute(new LoopTaskA());

        System.out.println("Main thread ends");
    }
}
