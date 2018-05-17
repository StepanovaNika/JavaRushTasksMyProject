package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Smitt", new Date("OCTOBER 8 1974" ));
        map.put("Adamson", new Date("JULY 5 1979"));
        map.put("Howard", new Date("MARCH 3 1981"));
        map.put("Leapman", new Date("FEBRUARY 1 1980"));
        map.put("Little", new Date("AUGUST 3 1980"));
        map.put("Stallone1", new Date("JULY 1 1980"));
        map.put("Stallone2", new Date("JUNE 1 1980"));
        map.put("Stallone3", new Date("NOVEMBER 1 1980"));
        map.put("Stallone4", new Date("SEPTEMBER 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8){
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}
