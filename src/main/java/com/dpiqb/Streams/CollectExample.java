package com.dpiqb.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> students = UtilMockData.getListOfStudents();

        System.out.println("Collectors.groupingBy");
        Map<Integer, List<Student>> collect = students.stream()
                .peek(student -> student.setName(student.getName().toUpperCase()))
                .collect(Collectors.groupingBy(student -> student.getCourse()));

        collect.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("Collectors.partitioningBy");
        Map<Boolean, List<Student>> collect1 = students.stream()
                .peek(student -> student.setName(student.getName().toUpperCase()))
                .collect(Collectors.partitioningBy(student -> student.getAvgGrade() > 8));

        collect1.forEach((key, value) -> System.out.println(key + ": " + value));

        Integer[] arr = new Integer[]{1, 2, 7, 3, 6, 5, 4, 2, 7, 6, 3, 1, 4, 5, 1, 7, 8, 2};
        Map<Integer, Long> collect2 = Arrays.stream(arr).collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println("collect2 = " + collect2);
    }
}
