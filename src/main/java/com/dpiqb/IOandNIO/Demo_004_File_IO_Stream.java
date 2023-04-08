package com.dpiqb.IOandNIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo_004_File_IO_Stream {
    public static void main(String[] args) {
        String from = "src/main/resources/java-logo-vert-blk.png";
        String to = "src/main/resources/java-logo-copied.png";

        try(FileInputStream fileInputStream = new FileInputStream(from);
            FileOutputStream fileOutputStream = new FileOutputStream(to)) {
            int i = 0;
            while (i != -1){
                i = fileInputStream.read();
                fileOutputStream.write(i);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
