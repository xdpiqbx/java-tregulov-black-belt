package com.dpiqb.CollectionFramework.ListIteratorExample;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
//        String str = "dpiqb";
        String str = "poiWiop";
        List<Character> list = new LinkedList<>();
        for (char c : str.toCharArray()){
            list.add(c);
        }
        System.out.println("list = " + list);

        int size = list.size();
        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reverseIterator = list.listIterator(size);

        boolean isPalindrome = true;
        int count = 0;
        while(iterator.hasNext() && reverseIterator.hasPrevious()){
            if(iterator.next() != reverseIterator.previous()){
                isPalindrome = false;
                break;
            }
            if(count > size/2){
                break;
            }
            count++;
        }
        System.out.println("isPalindrome = " + isPalindrome);

    }
}
