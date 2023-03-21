package com.dpiqb.Generics;

public class Subtyping {
    public static void main(String[] args) {
        Parent obj1 = new Child();
        // List<Parent> obj2 = new ArrayList<Child>(); // incompatible types!!!
    }
}

class Parent{}
class Child extends Parent{}