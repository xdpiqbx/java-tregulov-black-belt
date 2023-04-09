package com.dpiqb.IOandNIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo_006_Serialization_002 {
    public static void main(String[] args) {
        List<String> employees;
        String from = "src/main/resources/employees_001.bin";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(from))) {
            employees = (ArrayList) inputStream.readObject();
            System.out.println("employees = " + employees);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
