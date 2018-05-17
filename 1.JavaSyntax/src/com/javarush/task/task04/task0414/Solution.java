package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sx = reader.readLine();
        int a = Integer.parseInt(sx);
        int days;
        final int vg = 366;
        final int nvg = 365;
        if (a%4 == 0)
            if((a%100 == 0) && (a%400 != 0))
                days = nvg;
            else
                days = vg;
        else
            days = nvg;
        System.out.println("количество дней в году: " + days);

    }
}