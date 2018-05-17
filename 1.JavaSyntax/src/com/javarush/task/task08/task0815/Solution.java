package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код


        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Федоров","Алексей");
        map.put("Горин","Николай");
        map.put("Лайкина","Юлия");
        map.put("фамилия","Александр");
        map.put("Иванов","Иван");
        map.put("Лайкина1","Анна");
        map.put("Левин","Николай");
        map.put("Иванова","Юлия");
        map.put("фамилия2","Кирилл");
        map.put("Котякова","Анна");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String value : map.values()){
            if (value.equals(name))
                count++;
        }
        return count;


    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count2 = 0;
        for (String key : map.keySet()){
            if (key.equals(lastName))
                count2++;
        }
        return 1;

    }

    public static void main(String[] args) {


    }
}
