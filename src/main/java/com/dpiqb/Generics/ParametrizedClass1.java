package com.dpiqb.Generics;

public class ParametrizedClass1 {
    public static void main(String[] args) {
        Info<String> info1 = new Info<>("Hello");
        String strVal = info1.getValue();
        System.out.println(info1);

        Info<Integer> info2 = new Info<>(42);
        Integer intVal = info2.getValue();
        System.out.println(info2);
    }
}

class Info<T>{
    private final T value;
    public Info(T value){
        this.value = value;
    }
    public String toString(){
        return "{{-> " + value + " <-}}";
    }

    public T getValue() {
        return value;
    }
}