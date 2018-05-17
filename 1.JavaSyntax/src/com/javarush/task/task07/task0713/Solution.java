package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++){
            String s = reader.readLine();
            list.add(Integer.parseInt(s));
        }
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 3 == 0 || list.get(i) % 2 == 0) {
            if (list.get(i) % 3 == 0)
                    b.add(list.get(i));
                if ( list.get(i) % 2 == 0)
                    c.add(list.get(i));
            }
            else
                d.add(list.get(i));
        }
        printList(list);
        printList(b);
        printList(c);
        printList(d);

    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer i : list){
            System.out.println(i);
        }



    }
}
