package com.dpiqb.IOandNIO;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
public class Employee_1 implements Serializable {
    static final long serialVersionUID = 1;
    String name;
    String department;
    int age;
    transient double salary;
    Car car;
}
