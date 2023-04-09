package com.dpiqb.IOandNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Demo_007_RandomAccessFile {
    public static void main(String[] args) {
        String zapovit = "src/main/resources/zapovit.txt";
        try (RandomAccessFile file = new RandomAccessFile(zapovit, "rw")) {
//            int a = file.read();
//            System.out.println((char)a);

            String line = file.readLine();
            String utf8Line1 = new String(line.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            System.out.println(utf8Line1);

            file.seek(90); // the offset position, measured in bytes from the beginning of the file

            String currentLine = file.readLine();
            String utf8Line2 = new String(currentLine.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            System.out.println(utf8Line2);

            long filePointer = file.getFilePointer();
            System.out.println("filePointer = " + filePointer);

//            file.seek(0);
//            file.writeBytes("Hello!"); // It is not append! Write from above

            file.seek(file.length() - 1);
            file.writeBytes("\nThe End");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
