package com.dpiqb.IOandNIO;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class Demo_008_File {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test_001.txt");
        File folder = new File("src/main/resources/test_01");

        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath() = " + folder.getAbsolutePath());

        System.out.println("file.isAbsolute() = " + file.isAbsolute()); // false
        System.out.println("folder.isAbsolute() = " + folder.isAbsolute()); // false

        System.out.println("file.isDirectory() = " + file.isDirectory()); // false
        System.out.println("folder.isDirectory() = " + folder.isDirectory()); // true

        System.out.println("file.isHidden() = " + file.isHidden()); // false
        System.out.println("folder.isHidden() = " + folder.isHidden()); // false

        System.out.println("file.exists() = " + file.exists()); // true
        System.out.println("folder.exists() = " + folder.exists()); // true

        try {
            System.out.println("file.createNewFile() = " + file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("file.mkdir() = " + file.mkdir());

        File fileNew = new File("src/main/resources/test_001_NEW.txt");
        File folderNew = new File("src/main/resources/test_01_NEW");

        try {
            System.out.println("fileNew.createNewFile() = " + fileNew.createNewFile()); // first time - true
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("folderNew.mkdir() = " + folderNew.mkdir()); // first time - true

        System.out.println("file.length() = " + file.length()); // 499
        System.out.println("folder.length() = " + folder.length()); // 0

        System.out.println("fileNew.delete() = " + fileNew.delete()); // true
        System.out.println("folderNew.delete() = " + folderNew.delete()); // you can delete only empty folder - true

        File desktop = new File("C:/Users/Max/Desktop");
        File[] files = desktop.listFiles(); // Array of files
        Stream.of(files).forEach(System.out::println);

        System.out.println("file.isHidden() = " + file.isHidden());
        System.out.println("folder.isHidden() = " + folder.isHidden());

        System.out.println("file.canRead() = " + file.canRead()); // true / false
        System.out.println("file.canWrite() = " + file.canWrite()); // true / false
        System.out.println("file.canExecute() = " + file.canExecute()); // true / false
    }
}
