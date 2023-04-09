package com.dpiqb.IOandNIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo_006_Serialization_002_1 {
    public static void main(String[] args) {
        List<Employee_1> employees;
        String from = "src/main/resources/employees_001_1.bin";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(from))) {
            employees = (ArrayList) inputStream.readObject();
            System.out.println("employees = " + employees);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
