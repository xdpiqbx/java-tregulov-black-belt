package com.dpiqb.IOandNIO;

import java.io.FileWriter;
import java.io.IOException;

public class Demo_001_FileWriter {
    public static void main(String[] args) {
        String someText = "Краткие ежедневные занятия помогают накапливать знания.\n" +
                "Исследования доказывают, что студенты, выработавшие привычку регулярно учиться,\n" +
                "чаще достигают своих целей. Выделите немного времени для учебы\n" +
                "и установите напоминания с помощью инструментов учебного расписания.\n";

        try(FileWriter writer = new FileWriter("src/main/resources/test_001.txt")) {
            // write to file by symbols
            for (int i = 0; i < someText.length(); i++) {
                writer.write(someText.charAt(i));
            }
            System.out.println("Done_1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileWriter writer = new FileWriter("src/main/resources/test_002.txt")) {
            // write string to file
            writer.write(someText);
            System.out.println("Done_2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String addThisStringToExistingFile = "<<< Added to file >>>\n";

        try(FileWriter writer = new FileWriter("src/main/resources/test_001.txt", true)) {
            writer.write(addThisStringToExistingFile);
            System.out.println("Done_3");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        ClassLoader classLoader = Demo_001_FileWriter.class.getClassLoader();
//        System.out.println(Objects.requireNonNull(classLoader.getResource("test_001.txt")).getFile());
    }
}
