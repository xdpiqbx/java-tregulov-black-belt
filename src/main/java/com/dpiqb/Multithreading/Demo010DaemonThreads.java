package com.dpiqb.Multithreading;

public class Demo010DaemonThreads {
    public static void main(String[] args) {
        System.out.println("Main starts");
        UserThread thread1 = new UserThread();
        DaemonThread thread2 = new DaemonThread();

        thread2.setDaemon(true);

        thread2.setName("Daemon");
        thread1.setName("User");

        thread1.start();
        thread2.start();
    }
}
class UserThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Daemon " + isDaemon());
        for (char i = 'A'; i < 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DaemonThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Daemon " + isDaemon());
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}