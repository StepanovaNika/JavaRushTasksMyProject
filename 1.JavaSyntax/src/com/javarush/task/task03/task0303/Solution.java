package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(4,8));
        System.out.println(convertEurToUsd(5,7));

    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        double conv = eur * course;
        return conv;
    }
}
