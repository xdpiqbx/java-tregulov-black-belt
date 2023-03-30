package com.dpiqb.Multithreading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

public class Demo017Atomic {
//    static int counter = 0;
    static AtomicInteger counter = new AtomicInteger(0);
//    public static void increment(){
//        synchronized (Demo017Atomic.class){
//            counter++;
//        }
//    }
    public static void atomicIncrement(){
//        counter.incrementAndGet();
        counter.addAndGet(5);
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new AtomicImpl());
        Thread threadB = new Thread(new AtomicImpl());
        Thread threadC = new Thread(new AtomicImpl());
        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);
    }
}

class AtomicImpl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            Demo017Atomic.increment();
            Demo017Atomic.atomicIncrement();
        }
    }
}