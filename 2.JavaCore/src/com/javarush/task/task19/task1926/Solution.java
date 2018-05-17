package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while (br.ready()) {
            String res = br.readLine();
            System.out.println(new StringBuilder(res).reverse().toString());
        }
        br.close();


    }
}
