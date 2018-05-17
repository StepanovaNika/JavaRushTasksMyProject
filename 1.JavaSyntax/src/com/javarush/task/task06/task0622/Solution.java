package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int a[] = new int[5];
        for (int i = 0; i < a.length; i++){
            int b = Integer.parseInt(reader.readLine());
            a[i]+=b;
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
