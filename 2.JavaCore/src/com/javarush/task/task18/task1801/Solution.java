package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (in.available() > 0){
            int data = in.read();
            list.add(data);
            }
           int max = list.get(0);
            for (Integer i : list) {
                if (max < i)
                    max = i;
            }

        System.out.println(max);
        reader.close();
        in.close();


    }
}
