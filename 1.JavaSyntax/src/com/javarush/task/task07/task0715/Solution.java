package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        list.add(new String("мама"));
        list.add(new String("мыла"));
        list.add(new String("раму"));
        list.add(1,new String("именно"));
        list.add(3,new String("именно"));
        list.add(5,new String("именно"));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
