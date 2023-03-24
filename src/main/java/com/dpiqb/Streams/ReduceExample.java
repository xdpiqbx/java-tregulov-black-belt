package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        int[] nums = new int[]{6,37,326,198,7,21,6,378,94,62,31,78,42,1,93,8,7,4,6,23,6,4,72,81,36,4,78,236,43,2,4,32};
        int reduce = Arrays.stream(nums).reduce(0, (acc, el) -> acc + el);
        System.out.println(reduce);

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        String s = list.stream().reduce("!!!",(acc, item) -> acc + item);
        System.out.println(s);
    }
}
