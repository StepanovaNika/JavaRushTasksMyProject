package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/


import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IllegalAccessException {
        //напишите тут ваш код
        try {
        String n = args[0];
        BigInteger bi;
        boolean flag = false;
        for (int i = 2; i < 37; i++) {
            try {
                bi = new BigInteger(n, i);
                flag = true;
                if (flag) {
                    System.out.println(i);
                    break;
                }
            } catch (Exception e) {

            }
        }
            if (!flag) {
                throw new IllegalAccessException();
            }
        }catch (Exception e){
            System.out.println("incorrect");


        }
    }
}
