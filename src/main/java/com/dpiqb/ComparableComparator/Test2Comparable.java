package com.dpiqb.ComparableComparator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2Comparable {
    public static void main(String[] args) {
        List<EmployeeComparable> list = new ArrayList<>();
        EmployeeComparable employee1 = new EmployeeComparable(150, "John", "Salabun", 1232);
        EmployeeComparable employee2 = new EmployeeComparable(101, "Bill", "Deferson", 1392);
        EmployeeComparable employee3 = new EmployeeComparable(102, "Ann", "Abbain", 1900);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        Collections.sort(list);
        System.out.println(list);
    }
}

@Data
@AllArgsConstructor
class EmployeeComparable implements Comparable<EmployeeComparable> {
    int id;
    String name;
    String surname;
    int salary;

    @Override
    public int compareTo(EmployeeComparable o) {
//        return this.name.compareTo(o.name); // For Strings
//        return this.id - o.id; // For Numbers
        if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        } else {
            return this.surname.compareTo(o.surname);
        }
    }
}