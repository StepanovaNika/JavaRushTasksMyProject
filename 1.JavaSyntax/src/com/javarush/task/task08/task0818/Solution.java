package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Иванов", 600);
        map.put("Петров", 90);
        map.put("Сидоров", 345);
        map.put("Чеченов", 98765);
        map.put("Иванов2", 557);
        map.put("Клименко", 9876543);
        map.put("Петров2", 123);
        map.put("Арбузов", 567);
        map.put("Цветаева", 234);
        map.put("Иванова", 876);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> map1 = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : map1.entrySet()){
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}