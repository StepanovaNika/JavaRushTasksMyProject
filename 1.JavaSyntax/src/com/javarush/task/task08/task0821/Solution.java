package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String > map = new HashMap<>();
        map.put("фамилия","имя");
        map.put("фамилия1","имя1");
        map.put("фамилия","имя2");
        map.put("фамилия2","имя3");
        map.put("фамилия3","имя4");
        map.put("фамилия4","имя5");
        map.put("фамилия5","имя6");
        map.put("фамилия2","имя7");
        map.put("фамилия7","имя3");
        map.put("фамилия8","имя1");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
