package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DistinctCountPeekExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Six");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Eight");

        Stream<String> stream = list.stream();
        // stream.distinct().forEach(System.out::println); // only unic elements
        // System.out.println("stream.distinct().count() = " + stream.distinct().count()); // 8 unic elements
        stream.distinct().peek(System.out::println).count();
    }
}
