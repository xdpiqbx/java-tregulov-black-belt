package com.dpiqb.IOandNIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo_006_Serialization_001 {
    public static void main(String[] args) {
        String to = "src/main/resources/employees_001.bin";
        List<String> employees = new ArrayList<>();
        employees.add("Bill");
        employees.add("John");
        employees.add("David");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(to))) {
            outputStream.writeObject(employees);
            System.out.println("Done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
