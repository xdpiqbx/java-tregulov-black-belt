package com.dpiqb.Streams;

import java.util.List;
import java.util.stream.Collectors;

public class MapToIntExample {
    public static void main(String[] args) {
        List<Student> students = UtilMockData.getListOfStudents();
        List<Integer> ages = students.stream()
                .mapToInt(Student::getAge)
                .boxed() // ************************************** it boxed int to Integer
                .toList();
        System.out.println("collect = " + ages);

        double sum = students.stream().mapToDouble(Student::getAvgGrade).sum();
        System.out.println("sum = " + sum);

        double average = students.stream().mapToDouble(Student::getAvgGrade).average().getAsDouble();
        System.out.println("average = " + average);
    }
}
