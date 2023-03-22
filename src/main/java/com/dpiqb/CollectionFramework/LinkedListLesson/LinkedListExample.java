package com.dpiqb.CollectionFramework.LinkedListLesson;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        System.out.println("strings = " + strings);
        String remove = strings.remove(1);
        System.out.println("remove = " + remove);
        System.out.println("strings = " + strings);
    }
}
