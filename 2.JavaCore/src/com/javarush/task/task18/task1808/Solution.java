package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream in = new FileInputStream(file1);
        FileOutputStream outp = new FileOutputStream(file2);
        FileOutputStream outp1 = new FileOutputStream(file3);
        int a;
        while (in.available() > 0){
            if (in.available()%2 == 0){
                a = in.available()/2;
            } else
                a  = in.available()/ 2 + 1;
            byte [] buffer1 = new byte[a];
            byte [] buffer2 = new byte[in.available() / 2];

            outp.write(buffer1, 0, in.read(buffer1));
            outp1.write(buffer2, 0, in.read(buffer2));
        }
        reader.close();
        in.close();
        outp.close();
        outp1.close();
    }
}
