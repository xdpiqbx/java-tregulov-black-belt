package com.dpiqb.CollectionFramework.ArrayListLesson;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        System.out.println("before list = " + list); // [One, Two, Three, Four, Five]

        Iterator<String> iterator = list.iterator();

        int i = 0;
        while(iterator.hasNext()){
            System.out.println("in First while = " + iterator.next());
            if(i == 2){
                iterator.remove();
                break;
            }
            ++i;
        }

        System.out.println("after list = " + list); // [One, Two, Three, Five]

        while(iterator.hasNext()){
            System.out.println("in Second while = " + iterator.next());
        }

        while(iterator.hasNext()){
            System.out.println("in LAST while = " + iterator.next());
        }
    }
}
