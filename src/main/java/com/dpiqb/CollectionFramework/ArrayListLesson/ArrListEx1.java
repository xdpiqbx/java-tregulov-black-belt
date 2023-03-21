package com.dpiqb.CollectionFramework.ArrayListLesson;

import java.util.ArrayList;

public class ArrListEx1 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("One");
        list1.add("Three");
        list1.add("Two");

        ArrayList<String> list2 = new ArrayList<>(list1);

        System.out.println(list2 == list1); // FALSE ()
        System.out.println(list2.equals(list1)); // TRUE (same content)

        System.out.println(list2);
    }
}
