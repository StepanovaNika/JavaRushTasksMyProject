package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        int countS = 0;
        int countP = 0;
        while (in.available() > 0){
            countS++;
            int data = in.read();
            if (data == 32)
                countP++;

        }
        float result = (float) ((float)countP / countS*100.0);

        System.out.printf(Locale.ENGLISH, "%.2f", result);
        in.close();

    }
}
