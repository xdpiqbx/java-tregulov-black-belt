package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;

public class FindFirstExample {
    public static void main(String[] args) {
        List<Student> students = UtilMockData.getListOfStudents();

        // Returns an Optional describing the first element of this stream
        // If the stream has no encounter order, then any element may be returned.
        Student student1 = students.stream().findFirst().get();
        System.out.println("student1 = " + student1);

        // The behavior of this operation is explicitly NONdeterministic;
        // The cost is that multiple invocations on the same source may not return the same result.
        Student student2 = students.stream().findAny().get();
        System.out.println("student2 = " + student2);

    }
}
