package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> children1 = new ArrayList<Human>();

        Human Child1 = new Human("child1", true, 5);
        Human Child2 = new Human("child2", true, 5);
        Human Child3 = new Human("child3", true, 5);

        children1.add(Child1);
        children1.add(Child2);
        children1.add(Child3);


        Human father = new Human("father", true, 38, children1);
        Human mother = new Human("mother", false, 36,children1);

        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(father);

        ArrayList<Human> children3 = new ArrayList<Human>();
        children3.add(mother);

        Human grandFather = new Human("Gfather", true,67, children2);
        Human grandFather1 = new Human("Gfater1", true, 64, children3);

        Human grandMother = new Human("Gmother", false, 61,children2);
        Human grandMother1 = new Human("Gmother1", false, 60, children3);


        System.out.println(grandFather);
        System.out.println(grandFather1);
        System.out.println(grandMother);
        System.out.println(grandMother1);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(Child1);
        System.out.println(Child2);
        System.out.println(Child3);

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
         ArrayList<Human> children = new ArrayList<>();

        //напишите тут ваш код
        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
