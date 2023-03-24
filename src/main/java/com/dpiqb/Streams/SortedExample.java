package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SortedExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");

        // Stream<T> sorted();
        // Stream<T> sorted(Comparator<? super T> comparator);
        List<String> list1 = list.stream().sorted().toList();
        System.out.println("list1 = " + list1);
    }
}
