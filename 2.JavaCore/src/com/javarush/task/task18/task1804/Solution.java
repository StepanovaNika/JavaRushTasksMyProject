package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        while (in.available() > 0) {
            int data = in.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else map.put(data, 1);
        }
        in.close();

        int i = map.entrySet().iterator().next().getValue();
        if (!map.isEmpty()) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < i)
                    i = entry.getValue();
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == i)
                    System.out.print(entry.getKey() + " ");
            }
        }
    }
}
