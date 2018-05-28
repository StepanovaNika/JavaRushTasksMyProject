package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String s = reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]", "");
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
        }
        Iterator<Character> iterator = set.iterator();
        int n = set.size() > 5 ? 5 : set.size();
        for (int i = 0; i < n; i++) {
            System.out.print(iterator.next());
        }
    }
}
