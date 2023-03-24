package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterExample {
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

        // Stream<T> filter(Predicate<? super T> predicate);

        String[] strings = list.stream().filter(el -> el.length() > 3).toArray(String[]::new);
        System.out.println("strings = " + Arrays.toString(strings));
    }
}
