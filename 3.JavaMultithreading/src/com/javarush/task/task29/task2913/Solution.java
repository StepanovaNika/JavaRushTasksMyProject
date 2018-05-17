package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder res = new StringBuilder();
        res.append(a);
        int tmp = a;
        if (a == b) {
            return Integer.toString(a);
        } else {
            if (a > b) {
                while (tmp > b)
                    res.append(" ").append(--tmp);
            } else {
                while (tmp < b) {
                    res.append(" ").append(++tmp);
                }
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}