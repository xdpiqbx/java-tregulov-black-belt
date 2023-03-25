package com.dpiqb.Multithreading;

public class Demo001ExtendsThread {
    public static void main(String[] args) {
        DemoThread1 demoThread1 = new DemoThread1();
        DemoThread2 demoThread2 = new DemoThread2();

        demoThread1.start();
        demoThread2.start();
    }
}

class DemoThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("[Thread 1] = " + i);
        }
    }
}

class DemoThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println("{Thread 2} = " + i);
        }
    }
}
