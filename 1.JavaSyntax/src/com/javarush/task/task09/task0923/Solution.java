package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
    public static String str1 = new String();
    public static String str2 = new String();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();

        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++){
            if (b[i] == ' ') {
                continue;
            }
                if (isVowel(b[i])) {
                    str1 += b[i] + " ";
                } else {
                    str2 += b[i] + " ";

                }

        }
        System.out.println(str1);
        System.out.print(str2);

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}