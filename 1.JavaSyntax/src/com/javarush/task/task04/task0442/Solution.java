package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a =0;
        int b;
        for (;true;){
            b =Integer.parseInt(reader.readLine());
            a+=b;
            if (b== -1){
                break;
            }
        }
        System.out.println(a);

    }
}
