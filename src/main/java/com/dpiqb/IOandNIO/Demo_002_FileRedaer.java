package com.dpiqb.IOandNIO;

import java.io.FileReader;
import java.io.IOException;

public class Demo_002_FileRedaer {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/main/resources/test_001.txt")) {
            int character = 0;
            while(character != -1){
                character = fileReader.read();
                System.out.print((char)character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
