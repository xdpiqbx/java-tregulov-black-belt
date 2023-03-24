package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapExample {
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

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);

//        List<Integer> integers = list.stream().map(el -> el.length()).toList();
//        List<Integer> integers = list.stream().map(el -> el.length()).collect(Collectors.toList());
//        Integer[] integers = list.stream().map(el -> el.length()).toArray(size -> new Integer[size]);
        Integer[] integers = list.stream().map(String::length).toArray(Integer[]::new);
        System.out.println("Arrays.toString(integers) = " + Arrays.toString(integers));
    }
}
