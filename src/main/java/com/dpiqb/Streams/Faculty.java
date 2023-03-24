package com.dpiqb.Streams;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
public class Faculty {
    private final String title;
    private List<Student> students = new ArrayList<>();
    public void addStudent(Student s){
        this.students.add(s);
    }
}
