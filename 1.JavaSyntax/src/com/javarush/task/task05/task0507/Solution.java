package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = 0;
        int b;
        int i = 0;
        for (; true; ){
            b = Integer.parseInt(reader.readLine());

            if (b != -1){
                a+=b;
                i++;
            }
            else {
                break;
            }

        }
        System.out.println(a/i);
    }
}

