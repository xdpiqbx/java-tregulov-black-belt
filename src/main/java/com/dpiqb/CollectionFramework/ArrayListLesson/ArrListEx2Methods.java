package com.dpiqb.CollectionFramework.ArrayListLesson;

import java.util.ArrayList;
import java.util.List;

public class ArrListEx2Methods {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("One");
        list1.add("Three");
        list1.add("Two");

        list1.add(0, "Four"); // ********** add(index, value)
            System.out.println("list1.get(1) = " + list1.get(1)); // ********** get(index)
            System.out.println("list1 = " + list1);
        list1.set(1, "New"); // work like replace // ********** set(index, value)
            System.out.println("after set list1 = " + list1);
        list1.remove(0); // ********** remove(index)
            System.out.println("after remove = " + list1);
        list1.remove("Three"); // ********** remove(by_value!) it is possible if method equals was overridden
            System.out.println("after remove by value = " + list1); // [New, Two]

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Bill");
        list2.add("Steve");
        list2.add("John");
        list2.add("Steve");

        // list2.addAll(list1); // ********** addAll(any_list)
        list2.addAll(1, list1); // ********** addAll(index, any_list)
        System.out.println("\nlist2 = " + list2);
        // list2.clear(); // ********** clear() empty list []
        // list2.removeAll(list1); // remove all list1 elements from list2
        // list2.retainAll(list1); // retain only list1 elements in list2

        //subList Returns a view!!! of the portion of this list. Be careful with concurrent modification
        System.out.println("list2.subList(1, 4) = " + list2.subList(1, 4));

        System.out.println("list2.indexOf('Steve') = " + list2.indexOf("Steve")); // ********** indexOf(value) equals!
        System.out.println("list2.lastIndexOf('Steve') = " + list2.lastIndexOf("Steve")); // ********** lastIndexOf(value) equals!
        System.out.println("list2.size() = " + list2.size()); // ********** size()
        System.out.println("list2.isEmpty() = " + list2.isEmpty()); // ********** isEmpty() true/false
        System.out.println("list2.contains('John') = " + list2.contains("John")); // ********** contains(value) true/false equals!
        System.out.println("list2.containsAll(list1) = " + list2.containsAll(list1)); // ********** containsAll(list1) true/false equals!

        Object[] objectsArr = list2.toArray();
        String[] stringsArr = list2.toArray(new String[0]); // [0] and java will create correct size by itself

        List<Integer> integers = List.of(1, 2, 3, 4, 5); // immutable list!
        // integers.add(1, 10); // UnsupportedOperationException

        List<String> list = List.copyOf(list2); // immutable list!
        // list.add("Ololo"); // UnsupportedOperationException
        System.out.println("list = " + list);
    }
}
