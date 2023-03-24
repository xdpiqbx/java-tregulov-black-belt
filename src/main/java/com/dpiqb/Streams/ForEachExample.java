package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
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

        // Iterator
        // default void forEach(Consumer<? super T> action){...}

        // Stream
        // void forEach(Consumer<? super T> action);

        list.stream().map(el -> el + " !!!").forEach(System.out::println);
        System.out.println(list);
    }
}
