package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConcatExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("One");
        list1.add("Two");
        list1.add("Three");
        list1.add("Four");

        List<String> list2 = new ArrayList<>();
        list2.add("Five");
        list2.add("Six");
        list2.add("Seven");
        list2.add("Eight");

        Stream<String> stream1 = list1.stream();
        Stream<String> stream2 = list2.stream();
        Stream<String> stream3 = Stream.concat(stream1, stream2);

        // System.out.println("stream1.toList() = " + stream1.toList()); // stream has already been operated upon or closed
        // System.out.println("stream2.toList() = " + stream2.toList()); // stream has already been operated upon or closed
        System.out.println("stream3.toList() = " + stream3.toList());
    }
}
