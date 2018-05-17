package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] a = s.toCharArray();

        a[0] = Character.toUpperCase(a[0]);
        for (int i = 0; i < a.length; i++){
            if(a[i] == ' '){
                a[i + 1] = Character.toUpperCase(a[i + 1]);
            }
        }
        System.out.println(a);






    }
}
