package com.dpiqb.Multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo021ArrayBlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
        // queue.add(5); // capacity = 4 -> IllegalStateException: Queue full
        // queue.offer(5); // will not added.

        // Producer
        new Thread(() -> {
            int i = 0;
            while(true){
                try {
                    queue.put(i);
                    System.out.println("Added -> " + queue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        }).start();

        // Consumer
        new Thread(() -> {
            int i = 0;
            while(true){
                try {
                    queue.take();
                    System.out.println("Gets -> " + queue);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        }).start();
    }
}
