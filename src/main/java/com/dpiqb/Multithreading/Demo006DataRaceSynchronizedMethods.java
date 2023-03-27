package com.dpiqb.Multithreading;

public class Demo006DataRaceSynchronizedMethods {
    public static void main(String[] args) {
        DemoRunnable demoRunnable = new DemoRunnable();
        Thread thread1 = new Thread(demoRunnable);
        Thread thread2 = new Thread(demoRunnable);
        Thread thread3 = new Thread(demoRunnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter{
    static int count = 0; // volatile useless here. Data race here
}

class DemoRunnable implements Runnable{
    public synchronized void increment(){ // ******************* synchronized
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.increment(); // potentially Data race here
        }
    }
}