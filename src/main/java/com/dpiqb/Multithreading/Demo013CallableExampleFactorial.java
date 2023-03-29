package com.dpiqb.Multithreading;

import java.util.concurrent.*;

public class Demo013CallableExampleFactorial {
    protected static int factorialRes = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialCallable factorial = new FactorialCallable(5);
        Future<Integer> future = executorService.submit(factorial);

        try {
            System.out.println("future.isDone() = " + future.isDone());
            factorialRes = future.get();
            System.out.println("future.isDone() = " + future.isDone());
        } catch (InterruptedException | ExecutionException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }
        System.out.println("factorialRes: " + factorialRes);
    }
}

class FactorialCallable implements Callable<Integer> {
    int f;

    public FactorialCallable(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (this.f <= 0) {
            throw new IllegalArgumentException("Give me positive integer");
        }
        int result = 1;
        for (int i = 1; i <= this.f; i++) {
            result *= i;
        }
        return result;
    }
}