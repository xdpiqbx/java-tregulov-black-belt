package com.dpiqb.Multithreading;

public class Demo008DeadLock {
    protected static final Object lock1 = new Object();
    protected static final Object lock2 = new Object();

    public static void main(String[] args) {
        DemoDeadLockThread1 thread1 = new DemoDeadLockThread1();
        DemoDeadLockThread2 thread2 = new DemoDeadLockThread2();
        thread1.start();
        thread2.start();
    }
}

class DemoDeadLockThread1 extends Thread{
    @Override
    public void run() {
        this.setName("Biba");
        System.out.println(this.getName() + " Try to catch <[ lock 1 ]> object monitor");
        synchronized (Demo008DeadLock.lock1){
            System.out.println(this.getName() + " <[ lock 1 ]> object monitor is caught");
            System.out.println(this.getName() + " Try to catch {<[ lock 2 ]>} object monitor");
            synchronized (Demo008DeadLock.lock2){
                System.out.println("Both monitors are caught! In thread: " + this.getName());
            }
        }
    }
}

class DemoDeadLockThread2 extends Thread{
    @Override
    public void run() {
        this.setName("Boba");
        System.out.println(this.getName() + " Try to catch {<[ lock 2 ]>} object monitor");
        synchronized (Demo008DeadLock.lock2){
            System.out.println(this.getName() + " {<[ lock 2 ]>} object monitor is caught");
            System.out.println(this.getName() + " Try to catch <[ lock 1 ]> object monitor");
            synchronized (Demo008DeadLock.lock1){
                System.out.println("Both monitors are caught! In thread: " + this.getName());
            }
        }
    }
}

//    Biba Try to catch <[ lock 1 ]> object monitor
//    Boba Try to catch {<[ lock 2 ]>} object monitor

//    Biba <[ lock 1 ]> object monitor is caught
//    Boba {<[ lock 2 ]>} object monitor is caught

//    Biba Try to catch {<[ lock 2 ]>} object monitor
//    Boba Try to catch <[ lock 1 ]> object monitor