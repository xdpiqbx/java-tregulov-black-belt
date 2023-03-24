package com.dpiqb.Lambdas.UtilsFuncs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isGraterThanZero = x -> x > 0;
        Predicate<Integer> isOddNumber = x -> x % 2 == 0;
        Predicate<Integer> isEvenNumber = x -> x % 2 != 0;

        if (isGraterThanZero.test(4)) {
            System.out.println("Is Grater Than Zero!");
        }

        if (isGraterThanZero.or(isOddNumber).test(4)) {
            System.out.println("Is Odd and great than zero!");
        }

        if (isGraterThanZero.and(isOddNumber).test(4)) {
            System.out.println("is Grater Than Zero and is Odd Number");
        }

        if (isGraterThanZero.or(isOddNumber.and(isEvenNumber.negate())).test(4)) {
            System.out.println("isGraterThanZero.or(isOddNumber.and(isEvenNumber.negate())).test(4)");
        }

        if (isGraterThanZero.and(isOddNumber).and(isEvenNumber).negate().test(4)) {
            System.out.println("isGraterThanZero.and(isOddNumber).and(isEvenNumber).negate().test(4)");
        }

        Predicate<String> isEqual = Predicate.isEqual("Hello");
        if (isEqual.test("Hello")){
            System.out.println("isEqual.test('Hello')");
        }

        if (Predicate.isEqual("Hello").test("Hello")){
            System.out.println("isEqual.test('Hello')");
        }

        // ********************************************************************************

        List<String> models = new ArrayList<>();
        models.add("Mers");
        models.add("Lamborghini");
        models.add("Maserati");

        System.out.println("models = " + models);
        models.removeIf(str -> str.length() > 10);
        System.out.println("models = " + models);
    }
}
