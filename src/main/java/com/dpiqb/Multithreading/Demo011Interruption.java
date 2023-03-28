package com.dpiqb.Multithreading;

public class Demo011Interruption {
    public static void main(String[] args) {
        System.out.println("Main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main ends");

    }
}

class InterruptedThread extends Thread{
    @Override
    public void run() {
        int sum = 1;
        for (int i = 0; i < 1000000000; i++) {
            sum += Math.sqrt(i);
            if (isInterrupted()){
                break;
            }
        }
        System.out.println(sum);
    }
}