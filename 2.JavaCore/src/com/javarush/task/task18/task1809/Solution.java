package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream in = new FileInputStream(file1);
        FileOutputStream outp = new FileOutputStream(file2);
        byte [] buffer = new byte[in.available()];
        while (in.available() > 0){
            in.read(buffer);
        }
        byte[] buffer2 = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i ++){
            buffer2[i] = buffer[buffer.length-1-i];
        }
        outp.write(buffer2);

        reader.close();
        in.close();
        outp.close();
    }

}
