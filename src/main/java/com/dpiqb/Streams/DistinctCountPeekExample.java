package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DistinctCountPeekExample {
    public static void main(String[] args) {
        List<Student> students = UtilMockData.getListOfStudents();

        Stream<Student> stream = students.stream();
        // stream.distinct().forEach(System.out::println);
        // System.out.println("stream.distinct().count() = " + stream.distinct().count());
        stream.distinct().peek(System.out::println).count();
    }
}
