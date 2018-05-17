package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int Imin = 0, Imax = 0;
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s);
            if (Imin == 0) {
                Imin = s.length();
            }
            if (s.length() <= Imin) {
                Imin = s.length();
            } else if (s.length() >= Imax) {
                Imax = s.length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == Imin || list.get(i).length() == Imax ) {
                System.out.println(list.get(i));
                break;
            }
        }

    }
}
