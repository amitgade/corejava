package common;

import java.util.concurrent.ThreadFactory;

/**
 * Created by amit on 20-Dec-2020
 */
public class NamedThreadFactory implements ThreadFactory {

    private static int count = 0;
    private static String NAME = "PoolWorker-";

    @Override
    public Thread newThread(Runnable r) {

        // Runnable is generated and provided by JVM internally.
        // It's not the runnable task that we submit to the executor service

        Thread t = new Thread(r, NAME + ++count);
        return t;
    }
}
