package com.dpiqb.CollectionFramework.EqualsHashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student student1 = new Student("Zaur", "Treg", 3);
        Student student2 = new Student("Mary", "Iva", 1);
        Student student3 = new Student("Serg", "Petr", 4);
        map.put(student1, 5.1);
        map.put(student2, 6.5);
        map.put(student3, 9.2);
        System.out.println(map);

        Student student4 = new Student("Zaur", "Treg", 3);
        System.out.println("map.containsKey(student4) = " + map.containsKey(student4)); // without hashcode - FALSE
    }
}

class Student{
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && name.equals(student.name) && surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }
}