package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String st = reader.readLine();
        float t = Float.parseFloat(st)%5;
        if (t >= 0 && t < 3){
            System.out.println("зелёный");

        }
        else if (t >= 3 && t < 4){
            System.out.println("жёлтый");
        }
        else
            System.out.println("красный");
    }
}