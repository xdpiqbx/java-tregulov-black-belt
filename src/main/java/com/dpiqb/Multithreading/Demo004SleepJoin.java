package com.dpiqb.Multithreading;

public class Demo004SleepJoin {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            Thread.currentThread().setName("<<< FIRST >>>");
            Thread.State state = Thread.currentThread().getState();
            for (int i = 5; i > 0; i--) {
                System.out.printf("%s, state is: [%s] -> i = %d\n", Thread.currentThread().getName(), state, i);
                try {
                    Thread.sleep(1000L); // ************ sleep
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("GO!!!");
        });

        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName(">>> SECOND <<<");
            Thread.State state = Thread.currentThread().getState();
            for (int i = 5; i > 0; i--) {
                System.out.printf("%s, state is: [%s] -> i = %d\n", Thread.currentThread().getName(), state, i);
                try {
                    Thread.sleep(1000L); // ************ sleep
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("GO!!!");
        });

        System.out.println("Before .start() thread1 state is -> " + thread1.getState());
        System.out.println("Before .start() thread2 state is -> " + thread2.getState());

        thread1.start();
        thread2.start();

        thread1.join(); // main thread will wait for thread1
        // thread1.join(2000); // main will wait only for 2 sec

        System.out.println("Before .start() thread1 state is -> " + thread1.getState());
        System.out.println("Before .start() thread2 state is -> " + thread2.getState());
        System.out.printf("%s -> End\n", Thread.currentThread().getName());
    }
}
