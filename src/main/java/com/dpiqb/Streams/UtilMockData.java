package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;

public class UtilMockData {
    public static List<Student>getListOfStudents(){
        Student john = new Student("John", "m", 22, 3, 8.3);
        Student bill = new Student("Bill", "m", 28, 2, 6.4);
        Student viki = new Student("Viki", "f", 19, 1, 8.9);
        Student han = new Student("Han", "m", 35, 4, 7);
        Student elli = new Student("Elli", "f", 23, 3, 7.4);
        Student ben = new Student("Ben", "m", 20, 3, 8.4);
        Student steve = new Student("Steve", "m", 27, 4, 6.4);
        Student leia = new Student("Leia", "f", 19, 1, 9.4);

        List<Student> students = new ArrayList<>();

        students.add(john);
        students.add(bill);
        students.add(viki);
        students.add(han);
        students.add(elli);
        students.add(ben);
        students.add(steve);
        students.add(leia);

        return students;
    }
}
