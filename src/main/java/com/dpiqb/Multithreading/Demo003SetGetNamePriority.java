package com.dpiqb.Multithreading;

public class Demo003SetGetNamePriority {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("["+Thread.currentThread().getName()+"] = " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("["+Thread.currentThread().getName()+"] = " + i);
            }
        });

        thread1.setName("TooFast");
        thread2.setName("TheTurtle");
        thread2.setPriority(1);

        System.out.println("thread 1 getName() = " + thread1.getName()); // default -> Thread-0
        System.out.println("thread 1 getPriority() = " + thread1.getPriority()); // default -> 5

        System.out.println("thread 2 getName() = " + thread2.getName()); // default -> Thread-1
        System.out.println("thread 2 getPriority() = " + thread2.getPriority()); // default -> 5

        thread1.start();
        thread2.start();
    }
}
