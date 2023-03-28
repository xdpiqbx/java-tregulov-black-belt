package com.dpiqb.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo012ThreadPoolExecutorService {
    public static void main(String[] args) {
//        ExecutorService threadPoolExecService = Executors.newFixedThreadPool(5);
        ExecutorService threadPoolExecService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            threadPoolExecService.execute(new RunnableImpl());
        }
        threadPoolExecService.shutdown();
        try {
            // like a join but with a timer
            threadPoolExecService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main ends");
    }
}

class RunnableImpl implements Runnable{
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