package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        byte [] bytes = new byte[256];
        byte byteCH;
        while (in.available() > 0){
            byteCH = (byte) in.read();
            bytes[byteCH] += 1;
        }

        int maxValue=bytes[0];
        for(int i = 0; i < bytes.length; i++){
            int tmp =(int)bytes[i];
            if(tmp > maxValue)
                maxValue = tmp;
        }

        for(int i = 0; i < bytes.length; i++){
            if (bytes[i] == maxValue){
                System.out.print(i + " ");
            }
        }
        in.close();
        reader.close();
    }


    }
