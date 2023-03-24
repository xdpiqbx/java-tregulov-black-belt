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

        collect.forEach((key, value) -> System.out.println(key +": "+ value));

        System.out.println("Collectors.partitioningBy");
        Map<Boolean, List<Student>> collect1 = students.stream()
                .peek(student -> student.setName(student.getName().toUpperCase()))
                .collect(Collectors.partitioningBy(student -> student.getAvgGrade() > 8));

        collect1.forEach((key, value) -> System.out.println(key +": "+ value));
    }
}
