package com.dpiqb.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo012ThreadPoolExecutorService1 {
    public static void main(String[] args) {
//        ExecutorService threadPoolExecService = Executors.newFixedThreadPool(5);
        ExecutorService threadPoolExecService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            threadPoolExecService.execute(new RunnableImpl1());
        }
        try {
            // like a join but with a timer
            // in this example it like join for only 1 second
            threadPoolExecService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadPoolExecService.shutdown();
        System.out.println("Main ends");
    }
}

class RunnableImpl1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}