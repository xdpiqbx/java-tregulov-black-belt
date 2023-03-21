package com.dpiqb.Generics;

import java.util.ArrayList;
import java.util.function.Function;

public class ParametrizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        int a = GenMethod1.getSecondElement(list);
        System.out.println("a = " + a);
    }
}

class GenMethod1 {
    public static <T> T getSecondElement(ArrayList<T> a1) {
        return a1.get(1);
    }

    public static <T extends Number&Comparable&Function> T getLastElement(ArrayList<T> a1) { // ********************* <T extends Number>
        return a1.get(a1.size() - 1);
    }

    public <T> T getFirstElement(ArrayList<T> a1) {
        return a1.get(1);
    }
}

class GenMethod2<T> { // *********************************** <T>
    public static <T> T getFirstElement(ArrayList<T> a1) {
        return a1.get(0);
    }

    public T getSecondElement(ArrayList<T> a1) {
        return a1.get(1);
    }
}