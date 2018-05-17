package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(file1);

        FileOutputStream outputStream1 = new FileOutputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        byte [] buffer2 = new byte[inputStream2.available()];
        inputStream2.read();
        outputStream1.write(buffer2);

        byte [] buffer1 = new byte[inputStream1.available()];
        inputStream1.read();
        outputStream1.write(buffer1);

        inputStream2.close();
        outputStream1.close();
        inputStream1.close();

    }
}
