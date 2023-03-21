package com.dpiqb.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        // List<Number> list = new ArrayList<Integer>(); // incompatible types: Integer cannot be converted to Number
        // List<?> list = new ArrayList<Integer>();
         List<?> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        // list.add(123); // incompatible types: int cannot be converted to capture#1 of ?
         showListInfo(list);
    }
    static void showListInfo(List<?> list){
        System.out.println("My list " + list);
    }
}
