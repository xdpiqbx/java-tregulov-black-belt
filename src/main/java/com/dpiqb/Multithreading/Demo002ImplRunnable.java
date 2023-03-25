package com.dpiqb.Multithreading;

public class Demo002ImplRunnable {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DemoRunnable1());
        Thread thread2 = new Thread(new DemoRunnable2());
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("<- [new Runnable() Thread 3] = " + i);
                }
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("-[Lambda Thread 4] = " + i);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("====[Lambda Thread 5] = " + i);
            }
        }).start();
    }
}

class DemoRunnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("[Runnable Thread 1] = " + i);
        }
    }
}

class DemoRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println("{Runnable Thread 2} = " + i);
        }
    }
}