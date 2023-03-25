package com.dpiqb.Multithreading;

public class Demo005Volatile extends Thread{
    volatile boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag){
            i++;
        }
        System.out.println("Loop is finished: " + i);
    }

    public static void main(String[] args) {
        Demo005Volatile demoThread = new Demo005Volatile();
        demoThread.start();
        try {
            // main will sleep 1 sec
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        demoThread.flag = false;
        System.out.println("Main wake up!");
        System.out.println("The End");
    }
}
