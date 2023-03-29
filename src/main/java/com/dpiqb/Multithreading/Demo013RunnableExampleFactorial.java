package com.dpiqb.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Demo013RunnableExampleFactorial {
    protected static int factorialRes = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new FactorialRunnable(5));
        Future<?> future = executorService.submit(new FactorialRunnable(5));
        // future.get() // with runnable always null!
        // With Future you can use methods future.
        executorService.shutdown();
        try {
            System.out.println("future.isDone() = " + future.isDone());
            boolean isTerminated = executorService.awaitTermination(1000, TimeUnit.SECONDS);
            System.out.println("isTerminated: " + isTerminated);
            System.out.println("future.isDone() = " + future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(factorialRes);
    }
}

class FactorialRunnable implements Runnable {
    int f;

    public FactorialRunnable(int f) {
        this.f = f;
    }

    @Override
    public void run() {
        if (this.f <= 0) {
            System.out.println("Give me positive integer");
        }
        int result = 1;
        for (int i = 1; i <= this.f; i++) {
            result *= i;
        }
        Demo013RunnableExampleFactorial.factorialRes = result;
    }
}