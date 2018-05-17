package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 0){
            int maximum  = Integer.parseInt(reader.readLine());
            for ( ; n -1 > 0; n--){
                int b = Integer.parseInt(reader.readLine());
                if (b > maximum) {
                    maximum = b;
                }

            }
            System.out.println(maximum);


        }

        //напишите тут ваш код
    }
}
