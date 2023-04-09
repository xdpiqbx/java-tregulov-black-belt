package com.dpiqb.IOandNIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo_006_Serialization_001_1 {
    public static void main(String[] args) {
        String to = "src/main/resources/employees_001_1.bin";
        List<Employee_1> employees = new ArrayList<>();
        employees.add(new Employee_1("John", "IT", 23, 1000, new Car("Tesla", "silver")));
        employees.add(new Employee_1("Bill", "QA", 27, 1500, new Car("Toyota", "black")));
        employees.add(new Employee_1("Dan", "AI", 29, 1100, new Car("Bugatti", "red-black")));
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(to))) {
            outputStream.writeObject(employees);
            System.out.println("Done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
