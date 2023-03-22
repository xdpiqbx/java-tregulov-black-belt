package com.dpiqb.CollectionFramework.CollectionsLesson;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsLesson {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(7);
        integers.add(6);
        integers.add(1);
        integers.add(3);
        integers.add(4);
        integers.add(2);
        integers.add(5);
        System.out.println("integers = " + integers);
        Collections.sort(integers); // *************** Collections.sort(collection);
        System.out.println("integers = " + integers);
        int i = Collections.binarySearch(integers, 4); // *************** Collections.binarySearch(where, what);
        System.out.println("i = " + i);
        Collections.reverse(integers);
        System.out.println("reverse(integers) = " + integers); // *************** Collections.reverse(integers);
        Collections.shuffle(integers);
        System.out.println("shuffle(integers) = " + integers); // *************** Collections.shuffle(integers);
    }
}
