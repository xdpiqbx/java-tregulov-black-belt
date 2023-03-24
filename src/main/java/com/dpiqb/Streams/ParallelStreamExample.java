package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Student> students = UtilMockData.getListOfStudents();

        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        // Stream<List<Double>> listStream = Stream.of(list);
        // listStream.parallel();

        double sum = list.parallelStream().reduce((acc, element) -> acc + element).get();
        System.out.println("sum = " + sum);

        double divide = list.stream().reduce((acc, element) -> acc / element).get();
        System.out.println("divide = " + divide);

        double divideParallel = list.parallelStream().reduce((acc, element) -> acc / element).get();
        System.out.println("divideParallel = " + divideParallel);
    }
}
