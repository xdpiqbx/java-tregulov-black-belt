package com.dpiqb.Generics;

public class ParametrizedClass2 {
    Pair<String, Integer> pair1 = new Pair<>("Hello", 42);
    // Pair<String, Integer> pair3 = new Pair<>("Hello", "42"); // "42" - String not extends Number
    SameTypePair<String> pair2 = new SameTypePair<>("Hello", "World");
}

class Pair<V1, V2 extends Number> {
    private final V1 value1;
    private final V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getFirstValue() {
        return value1;
    }

    public V2 getSecondValue() {
        return value2;
    }
}

class SameTypePair<V> {
    private final V value1;
    private final V value2;

    public SameTypePair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getFirstValue() {
        return value1;
    }

    public V getSecondValue() {
        return value2;
    }
}