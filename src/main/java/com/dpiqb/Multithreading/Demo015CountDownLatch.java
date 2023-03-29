package com.dpiqb.Multithreading;

import java.util.concurrent.CountDownLatch;

public class Demo015CountDownLatch {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static void marketStaffIsOnPlace(){
        try {
            Thread.sleep(2000);
            System.out.println("Market staff came to work");
            countDownLatch.countDown();
            System.out.println("countDownLatch.getCount() => " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static void everythingIsReady(){
        try {
            Thread.sleep(3000);
            System.out.println("everything is ready, we can open.");
            countDownLatch.countDown();
            System.out.println("countDownLatch.getCount() => " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static void openMarket(){
        try {
            Thread.sleep(4000);
            System.out.println("Market is OPEN!");
            countDownLatch.countDown();
            System.out.println("countDownLatch.getCount() => " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Friend("Bill", countDownLatch);
        new Friend("John", countDownLatch);
        new Friend("Albert", countDownLatch);

        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
    }
}

class Friend extends Thread{
    String name;
    private final CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(this.name + "begin his shopping =)");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
