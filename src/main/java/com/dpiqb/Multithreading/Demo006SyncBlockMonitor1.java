package com.dpiqb.Multithreading;

public class Demo006SyncBlockMonitor1 {
    public static void main(String[] args) {
        DemoRunnableOne demoRunnable = new DemoRunnableOne();
        Thread thread1 = new Thread(demoRunnable);
        Thread thread2 = new Thread(demoRunnable);
        Thread thread3 = new Thread(demoRunnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class CounterDemo1{
    static int count = 0;
}

class DemoRunnableOne implements Runnable{
    public void increment(){
        // Some other not synchronized logic
        synchronized (this){ // *********************** I will use lock on `this` obj monitor
            CounterDemo1.count++;
            System.out.print(CounterDemo1.count + " ");
        }
        // Some other not synchronized logic
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.increment(); // potentially Data race here
        }
    }
}