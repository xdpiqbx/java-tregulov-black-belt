package com.dpiqb.IOandNIO;

import java.io.*;

public class Demo_005_Data_IO_Stream {
    public static void main(String[] args) {
        String from = "src/main/resources/some.bin";
        String to = "src/main/resources/some.bin";
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(to));
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(from));
            ) {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(5);
            dataOutputStream.writeShort(122);
            dataOutputStream.writeInt(100500);
            dataOutputStream.writeLong(1000000);
            dataOutputStream.writeFloat(3.14F);
            dataOutputStream.writeDouble(1123.456);

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readByte());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
