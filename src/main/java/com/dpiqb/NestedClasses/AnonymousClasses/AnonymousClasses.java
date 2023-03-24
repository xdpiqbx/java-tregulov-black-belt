package com.dpiqb.NestedClasses.AnonymousClasses;

public class AnonymousClasses {
    public static void main(String[] args) {
        Math m1 = new Math() {
            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }
        };

        Math m2 = (a, b) -> a / b;

        System.out.println("m1.doOperation(5, 4) = " + m1.doOperation(5, 4));
        System.out.println("m2.doOperation(5, 4) = " + m2.doOperation(5, 4));
    }
}

interface Math{
    int doOperation(int a, int b);
}
