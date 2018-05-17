package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream filename = new FileInputStream(br.readLine());
        BufferedReader brnum = new BufferedReader(new InputStreamReader(filename));

        ArrayList<Integer> list = new ArrayList<Integer>();
        String num;

        while ((num = brnum.readLine()) != null) {
            int number = Integer.parseInt(num);
            if ((number%2==0)) {
                list.add(number);
            }
        }
        filename.close();

        Collections.sort(list);
        for (int x: list) {
            System.out.println(x);
        }
    }
}
