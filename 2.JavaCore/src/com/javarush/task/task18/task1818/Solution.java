package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            String file3 = reader.readLine();
            reader.close();
            FileOutputStream outputStream = new FileOutputStream(file1);
            FileInputStream inputStream1 = new FileInputStream(file2);
            FileInputStream inputStream2 = new FileInputStream(file3);

        byte[] buffer1 = new byte[inputStream1.available()];
        inputStream1.read(buffer1);
        outputStream.write(buffer1);
        inputStream1.close();

        byte[] buffer2 = new byte[inputStream2.available()];
        inputStream2.read(buffer2);
        outputStream.write(buffer2);


        outputStream.close();
        inputStream2.close();



    }
}
