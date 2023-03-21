package com.dpiqb.ComparableComparator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Test3Comparator {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee(150, "John", "Salabun", 1232);
        Employee employee2 = new Employee(101, "Bill", "Deferson", 1392);
        Employee employee3 = new Employee(102, "Ann", "Abbain", 1900);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        Collections.sort(list, new IdComparator());
        System.out.println(list);

        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(list);

        Collections.sort(list, (o1, o2) -> o1.salary - o2.salary);
        System.out.println(list);

        Collections.sort(list, Comparator.comparing(o -> o.surname));
        System.out.println(list);
    }
}

@Data
@AllArgsConstructor
class Employee{
    int id;
    String name;
    String surname;
    int salary;
}

class IdComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.id - o2.id;
    }
}