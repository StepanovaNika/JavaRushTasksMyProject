package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[15];
        for (int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }
        int sumP = 0;
        int sumO = 0;
        for (int i = 0; i < a.length; i++) {
            if ((i % 2) == 0) {
                sumP += a[i];
            } else
                sumO += a[i];

        }
        System.out.println(sumO > sumP ? "В домах с нечетными номерами проживает больше жителей." : "В домах с четными номерами проживает больше жителей.");

    }
}
