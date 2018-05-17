package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader rd = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);
        reader.close();
        int i = 0;
        while (rd.ready()){
            i++;
            int data = rd.read();
            if (i%2 == 0)
                fw.write(data);
        }
        rd.close();
        fw.close();
    }
}
