package com.dpiqb.Multithreading;

import java.util.concurrent.*;

public class Demo012ThreadPoolExecutorService2 {
    public static void main(String[] args) {
        System.out.println("Main is started ...");
        ScheduledExecutorService schExecService = Executors.newScheduledThreadPool(1);
        // in this example I scheduled the task after 3 seconds
        // schExecService.schedule(new RunnableImpl2(), 3, TimeUnit.SECONDS);

        // (task, the first time it will be started after 1 second, and the task will repeat every 2 seconds without delay, TimeUnit.SECONDS)
        // schExecService.scheduleAtFixedRate(new RunnableImpl2(), 1, 2, TimeUnit.SECONDS);

        // (task, the first time will be started after 2 seconds, and the task will repeat after every 2 seconds, TimeUnit.SECONDS)
        schExecService.scheduleWithFixedDelay(new RunnableImpl2(), 2, 3, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            schExecService.shutdown();
        }
        System.out.println("Main ends.");
    }
}

class RunnableImpl2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is started ...");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(Thread.currentThread().getName() + "END!");
    }
}