package com.javarush.task.task07.task0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        list.add(0, "В одно");
        list.add(1, "мгновенье");
        list.add(2, "видеть");
        list.add(3, "вечеость");
        list.add(4, "огромный мир");
        int n = list.size();
        System.out.println(n);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


    }
}
