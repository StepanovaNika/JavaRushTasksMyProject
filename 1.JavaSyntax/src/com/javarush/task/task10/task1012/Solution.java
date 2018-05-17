package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        for (int i = 0; i < alphabet.size(); i++) {
            int count = 0;
            for (String a : list) {
                char[] chars = a.toCharArray();
                for (char b : chars) {
                    if (alphabet.get(i).equals(b)) {
                        count++;
                    }
                }
            }
            if (i == alphabet.size() - 1) {
                System.out.println(alphabet.get(i) + " " + count);

            } else
                System.out.println(alphabet.get(i) + " " + count);

        }
    }
}
