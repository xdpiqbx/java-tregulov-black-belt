package com.dpiqb.Lambdas;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {
    public static void main(String[] args) {
        AtomicInteger res = new AtomicInteger();

        String result = printStrLen(
                "Hello world",
                (str) -> {
                    System.out.println("Length of [" + str + "] is: " + str.length());
                    // int result = 42; // variable result is already defined in method main
                    res.set(42);
                    return res.get();
                }
        );

        System.out.println(result);
        // -------
        SomeInterface si = someStr -> someStr.length() - 1;
        System.out.println("printStrLen('Hello', si) = " + printStrLen("Hello", si));
    }
    static String printStrLen(String str, SomeInterface si){
        return "This is result -> " + si.someMethodReturnsInt(str);
    }
}

interface SomeInterface{
    int someMethodReturnsInt(String s);
}