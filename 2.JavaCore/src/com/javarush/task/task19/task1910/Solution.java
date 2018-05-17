package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        while (br.ready()){
            String s = br.readLine();
            bw.write(s.replaceAll("[\\p{Punct}\\n]",""));

        }
        br.close();
        bw.close();
    }
}
