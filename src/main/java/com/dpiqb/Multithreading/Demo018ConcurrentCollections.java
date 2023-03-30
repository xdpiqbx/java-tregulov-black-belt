package com.dpiqb.Multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo018ConcurrentCollections {
    public static void main(String[] args) {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            source.add(i);
        }

        ArrayList<Integer> target = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(target);

        Runnable runnable = () -> {
//            target.addAll(source);
            syncList.addAll(source);
        };

        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(target);
    }
}
