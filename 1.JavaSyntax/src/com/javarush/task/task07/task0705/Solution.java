package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a[] = new int[20];
        for (int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }


        int b[] = new int[10];
        int c[] = new int[10];
        for (int i = 0; i < 10; i++) {
            b[i] = a[i];
        }
        for (int i = 0; i < 10; i++) {
            c[i] = a[10 + i];
        }
        for (int i = 0; i < c.length; i++){
            System.out.println(c[i]);
        }


    }
}
