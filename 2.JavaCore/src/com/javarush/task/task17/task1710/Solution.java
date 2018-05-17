package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        if (args[0].equals("-c")){
            String name = args[1];
            Sex sex = "м".equals(args[2]) ? Sex.MALE : Sex.FEMALE;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date bd = dateFormat.parse(args[3]);
            Person p = (sex == Sex.MALE) ? Person.createMale(name, bd) : Person.createFemale(name, bd);

            allPeople.add(p);
            System.out.println(allPeople.size()-1);
        }
        else if (args[0].equals("-u")){
            int index = Integer.parseInt(args[1]);
            String name = args[2];
            Sex sex = "м".equals(args[3]) ? Sex.MALE : Sex.FEMALE;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date bd = dateFormat.parse(args[4]);

            Person person = allPeople.get(index);
            person.setName(name);
            person.setSex(sex);
            person.setBirthDay(bd);
        }
        else if (args[0].equals("-d")){
            int index = Integer.parseInt(args[1]);
            Person p = allPeople.get(index);
            p.setName(null);
            p.setSex(null);
            p.setBirthDay(null);
        }
        else if (args[0].equals("-i")){
            int index = Integer.parseInt(args[1]);
            Person p = allPeople.get(index);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
            String bd = dateFormat.format(p.getBirthDay());
            System.out.println(p.getName() + " " + (p.getSex() == Sex.MALE ? "м" : "ж") + " " +  bd);


        }

    }
}
