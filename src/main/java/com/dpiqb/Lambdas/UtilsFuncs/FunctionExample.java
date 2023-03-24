package com.dpiqb.Lambdas.UtilsFuncs;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> func = str -> str +" World"; // Function<GetType, ResultType>

        String resultString = func.apply("Hello");

        System.out.println("resultString = " + resultString);

        func.compose((str) -> str + " Bill").apply("Hello"); // Hello Bill World // BEFORE!
        func.andThen((str) -> str + " Bill").apply("Hello"); // Hello World Bill // AFTER!
    }
}

