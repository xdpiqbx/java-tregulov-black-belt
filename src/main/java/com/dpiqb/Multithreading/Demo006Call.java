package com.dpiqb.Multithreading;

public class Demo006Call {
    static final Object lock = new Object();
    void call(String typeCall, long msTime){
        synchronized (lock){
            System.out.println(typeCall + " call starts");
            try {
                Thread.sleep(msTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(typeCall + " call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MobileCall());
        Thread thread2 = new Thread(new WhatsappCall());
        Thread thread3 = new Thread(new SkypeCall());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MobileCall implements Runnable{
    @Override
    public void run() {
        new Demo006Call().call("Mobile", 3000);
    }
}
class WhatsappCall implements Runnable{
    @Override
    public void run() {
        new Demo006Call().call("Whatsapp", 5000);
    }
}
class SkypeCall implements Runnable{
    @Override
    public void run() {
        new Demo006Call().call("Skype", 7000);
    }
}