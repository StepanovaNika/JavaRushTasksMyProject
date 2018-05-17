package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int otr = 0;
        int p = 0;

        if (a > 0)
            p++;
        if (a < 0)
            otr++;

        if (b > 0)
            p++;
        if (b < 0)
            otr++;

        if (c > 0)
            p++;
        if (c < 0)
            otr++;
        System.out.println("количество отрицательных чисел: " + otr);
        System.out.println("количество положительных чисел: " + p);

    }
}
