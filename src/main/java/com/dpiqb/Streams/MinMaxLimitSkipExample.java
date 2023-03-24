package com.dpiqb.Streams;

import java.util.List;
import java.util.stream.Stream;

public class MinMaxLimitSkipExample {
    public static void main(String[] args) {
        List<Student> students = UtilMockData.getListOfStudents();

        System.out.println("Max");
        Student student1 = students.stream().max((s1, s2) -> (int) (s1.getAvgGrade() - s2.getAvgGrade())).get();
        System.out.println("student1 = " + student1);

        System.out.println("Min");
        Student student2 = students.stream().min((s1, s2) -> (int) (s1.getAvgGrade() - s2.getAvgGrade())).get();
        System.out.println("student2 = " + student2);

        System.out.println("Limit");
        students.stream().limit(5).forEach(System.out::println);

        // Do not forget about this!!!
        Stream<Student> streamOfStudents = students.stream();
        System.out.println("Limit1");
        streamOfStudents.limit(2).forEach(System.out::println);
        System.out.println("Limit2");
        // streamOfStudents.forEach(System.out::println); // stream has already been operated upon or closed

        System.out.println("Skip");
        students.stream().skip(2).forEach(System.out::println);
    }
}
