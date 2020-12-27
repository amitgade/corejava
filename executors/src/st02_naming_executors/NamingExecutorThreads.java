package st02_naming_executors;

import common.LoopTaskC;
import common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by amit on 20-Dec-2020
 */
public class NamingExecutorThreads {
    public static void main(String[] args) {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts ...");

        // default way : thread will be named as - pool-M-thread-N
//        ExecutorService executorService = Executors.newCachedThreadPool();

        // name thread Pool by using ThreadFactory instance as constructor argument
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        for (int i = 0; i < 3; i++) {
            executorService.execute(new LoopTaskC());
        }

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends ..." );
    }
}
