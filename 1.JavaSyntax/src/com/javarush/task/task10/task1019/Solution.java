package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            String id = reader.readLine();
            if (id.isEmpty()){
                break;
            }
            int index = Integer.parseInt(id);
            String name = reader.readLine();
            if (name.isEmpty()){
                break;
            }
            map.put(name, index);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
