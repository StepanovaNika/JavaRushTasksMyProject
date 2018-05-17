package com.javarush.task.task30.task3009;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
    private static Set<Integer> getRadix(String number){
        Set<Integer> res = new HashSet<>();
        StringBuilder sb;
        try {
            int index = Integer.parseInt(number);
            for (int i = 2; i < 37; i++) {
                sb = new StringBuilder(Integer.toString(index, i));
                if (sb.toString().equals(sb.reverse().toString())){
                    res.add(i);
                }
            }
        }catch (NumberFormatException e){

        }
        return res;
    }
}