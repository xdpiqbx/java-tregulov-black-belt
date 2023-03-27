package com.dpiqb.Multithreading;

public class Demo007WaitNotify {
    public static void main(String[] args) {
        Market market = new Market(0);
        Thread thread1 = new Thread(new Consumer(market));
        Thread thread2 = new Thread(new Producer(market));
        thread1.start();
        thread2.start();
    }
}

class Market {
    private static final Object lock = new Object();
    private int breadAmount;

    public Market(int breadAmount) {
        this.breadAmount = breadAmount;
    }

//    public synchronized void getBread() {
    public void getBread() {
        synchronized (lock) {
            while (this.breadAmount < 1) {
                try {
                    lock.wait(); // ****************************************** wait()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.breadAmount--;
            System.out.println("Bought 1 bread left " + this.breadAmount);
            lock.notify(); // ************************************************ notify()
        }
    }

//    public synchronized void addBread() {
    public void addBread() {
        synchronized (lock) {
            while (this.breadAmount >= 100) {
                try {
                    lock.wait(); // ****************************************** wait()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.breadAmount++;
            System.out.println("Added 1 bread, showcase " + this.breadAmount);
            lock.notify(); // ************************************************ notify()
        }
    }
}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            market.addBread();
        }
    }
}

class Consumer implements Runnable {

    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            market.getBread();
        }
    }
}
