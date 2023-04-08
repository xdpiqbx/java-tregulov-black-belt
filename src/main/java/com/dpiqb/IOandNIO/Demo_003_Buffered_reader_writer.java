package com.dpiqb.IOandNIO;

import java.io.*;

public class Demo_003_Buffered_reader_writer {
    public static void main(String[] args) {
        textFileReadWrite();
    }
    private static void textFileReadWrite(){
        String pathFrom = "src/main/resources/test_001.txt";
        String pathTo = "src/main/resources/test_002.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFrom));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathTo))) {

//            int character = 0;
//            while (character != -1) {
//                character = reader.read();
//                writer.write(character);
//            }

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }

            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
