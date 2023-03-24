package com.dpiqb.Streams;

import java.util.ArrayList;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        Student john = new Student("John", "m", 22, 3, 8.3);
        Student bill = new Student("Bill", "m", 28, 2, 6.4);
        Student viki = new Student("Viki", "f", 19, 1, 8.9);
        Student han = new Student("Han", "m", 35, 4, 7);
        Student elli = new Student("Elli", "f", 23, 3, 7.4);
        Student ben = new Student("Ben", "m", 20, 3, 8.4);
        Student steve = new Student("Steve", "m", 27, 4, 6.4);
        Student leia = new Student("Leia", "f", 19, 1, 9.4);

        Faculty economic = new Faculty("Economic");
        Faculty math = new Faculty("Mathematics");
        Faculty bio = new Faculty("Biological");

        economic.addStudent(john);
        economic.addStudent(bill);
        economic.addStudent(viki);
        math.addStudent(han);
        math.addStudent(elli);
        bio.addStudent(ben);
        bio.addStudent(steve);
        bio.addStudent(leia);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(economic);
        faculties.add(math);
        faculties.add(bio);

        faculties.stream()
                .forEach(
                        faculty -> faculty.getStudents().stream()
                                .forEach(
                                        student -> System.out.println(student.getName())
                                )
                );

        // <R> Stream<R>     map(Function<? super T,                  ? extends R>  mapper);
        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        faculties.stream()
                .flatMap(faculty -> faculty.getStudents().stream()) // ********************* flatmap()
                .forEach(student -> System.out.println("[" + student.getName() + "]"));

        faculties.stream()
                .filter(faculty -> faculty.getTitle().equals("Economic") || faculty.getTitle().equals("Mathematics"))
                .flatMap(faculty -> faculty.getStudents().stream()) // ********************* flatmap()
                .forEach(student -> System.out.println("{" + student.getName() + "}"));
    }
}
