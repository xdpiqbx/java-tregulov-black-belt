package com.dpiqb.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo009ATMLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(); // ********************** ReentrantLock
        new Employee("Bill", lock);
        new Employee("John", lock);
        new Employee("Artem", lock);

        new HurryEmployee("2 Pack", lock);
        new HurryEmployee("Snoop Dog", lock);
        new HurryEmployee("Eminem", lock);
        new HurryEmployee("Dr.Dre", lock);
    }
}

class Employee extends Thread {
    private String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(this.name + " is wait ...");
        this.lock.lock();
        System.out.println(this.name + " use ATM");
        try {
            Thread.sleep(2000L);
            System.out.println(this.name + " is go away. ATM free.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.lock.unlock();
        }
    }
}

class HurryEmployee extends Thread {
    private String name;
    private Lock lock;

    public HurryEmployee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        if (this.lock.tryLock()) {
            System.out.println(this.name + " use ATM");
            try {
                Thread.sleep(2000L);
                System.out.println(this.name + " is go away. ATM free.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                this.lock.unlock();
            }
        } else {
            System.out.println(this.name + " do not want to wait");
        }
    }
}