package com.dpiqb.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo009LockReentrantLock {
    public static void main(String[] args) {
        Call call = new CallReentrantLock();
        Thread thread1 = new Thread(() -> {
            call.call("Phone", 3000L);
        });
        Thread thread2 = new Thread(() -> {
            call.call("Whatsapp", 5000L);
        });
        Thread thread3 = new Thread(() -> {
            call.call("Skype", 7000L);
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class CallReentrantLock implements Call {
    private final Lock lock = new ReentrantLock();

    public void call(String typeCall, long time) {
        lock.lock();
        try {
            String startCall = String.format("%s call starts", typeCall);
            String endCall = String.format("%s call ends", typeCall);
            System.out.println(startCall);
            Thread.sleep(time);
            System.out.println(endCall);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

class CallSynchronized implements Call {
    public synchronized void call(String typeCall, long time) {
        try {
            String startCall = String.format("%s call starts", typeCall);
            String endCall = String.format("%s call ends", typeCall);
            System.out.println(startCall);
            Thread.sleep(time);
            System.out.println(endCall);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

interface Call {
    void call(String typeCall, long time);
}