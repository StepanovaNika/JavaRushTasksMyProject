package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        String y = reader.readLine();
        int lx = x.length();
        int ly = y.length();
        if (x.equals(y)){
            System.out.println("Имена идентичны");
        }
        else if (lx == ly && x.equals(y) == false){
            System.out.println("Длины имен равны");
        }

    }
}
