package com.dpiqb.Multithreading;

import lombok.AllArgsConstructor;

import java.util.concurrent.Semaphore;

public class Demo014Semaphore {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        Thread bill = new Thread(new Person("Bill", callBox));
        Thread john = new Thread(new Person("John", callBox));
        Thread robert = new Thread(new Person("Robert", callBox));
        bill.start();
        john.start();
        robert.start();
    }
}

@AllArgsConstructor
class Person implements Runnable{
    String name;
    Semaphore callBox;
    @Override
    public void run() {
        try {
            System.out.printf("%s is waiting now ... \n", this.name);
            callBox.acquire();
            System.out.printf("%s is Calling now ... \n", this.name);
            Thread.sleep(2000);
            System.out.printf("%s is go away. Phone is free.\n", this.name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            callBox.release();
        }
    }
}