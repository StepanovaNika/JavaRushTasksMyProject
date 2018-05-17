package com.javarush.task.task08.task0817;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Тупов","Эдуард");
        map.put("Тупов2","Дима");
        map.put("Тупов3","Артем");
        map.put("Ющенко","Эдуард");
        map.put("Ющенко2","Дима");
        map.put("Ющенко3","Артем");
        map.put("Смежный","Эдуард");
        map.put("Смежный2","Дима");
        map.put("Смежный3","Артем");
        map.put("Эдуард1","Эдуард1");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код

        HashMap<String, String> map1 = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : map1.entrySet()) {

            if ((Collections.frequency(map1.values(), pair.getValue())) > 1)
                removeItemFromMapByValue(map, pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
