package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));


    }

    public static boolean isDateOdd(String date) {
        Date start = new Date(date);
        start.setMonth(0);
        start.setDate(0);
        Date current = new Date(date);
        long msDist = current.getTime() - start.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int сount = (int)(msDist/msDay);

        return ((сount % 2 != 0)? true : false);

    }
}
