package com.dpiqb.Multithreading;

public class Demo006SyncBlockMonitor2 {
    volatile static int counter = 0;
    public static synchronized void increment(){
        synchronized (Demo006SyncBlockMonitor2.class){ // ************* synchronized (Demo006SyncBlockMonitor2.class)
            counter++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new DemoRunnableTwo());
        Thread thread2 = new Thread(new DemoRunnableTwo());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class DemoRunnableTwo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Demo006SyncBlockMonitor2.increment();
        }
    }
}
