package com.dpiqb.Streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private String sex;
    private int age;
    private int course;
    private double avgGrade;
}
