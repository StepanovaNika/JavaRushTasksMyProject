package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double median = 0;
        Integer[] sortarray = array;
        Arrays.sort(sortarray);
        if (sortarray.length %2 == 0){
            int a = sortarray[(sortarray.length/2) - 1];
            int b = sortarray[sortarray.length/2];
            median = (a+b)/2.0;
        }
        else
            median = sortarray[sortarray.length/2];
        final double fMedian = median;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = (int) (Math.abs(o1 - fMedian) - Math.abs(o2 - fMedian));
                return res == 0? o1 - o2 : res;
            }
        };
        Arrays.sort(array, comparator);

        return array;
    }
}
