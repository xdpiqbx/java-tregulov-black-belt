package com.dpiqb.Multithreading;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Demo019ConcurrentHashMap {
    public static void main(String[] args) {
//        HashMap<Integer, String> map = new HashMap<>(); // Concurrent Modification Exception
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Bill");
        map.put(2, "Gool");
        map.put(3, "Dert");
        map.put(4, "Zarg");
        System.out.println(map);

        Runnable runnableIterate = () -> {
            Iterator<Integer> iter = map.keySet().iterator();
            while (iter.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iter.next();
                System.out.printf("key: %d => value: %s\n", i, map.get(i));
            }
        };

        Runnable runnablePutToMap = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put(5, "John");
        };

        Thread thread1 = new Thread(runnableIterate);
        Thread thread2 = new Thread(runnablePutToMap);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
