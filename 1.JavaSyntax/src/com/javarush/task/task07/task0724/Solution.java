package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFather1 = new Human("Василий", true,66);
        Human grandFather2 = new Human("Игорь", true, 70);

        Human grandMother1 = new Human("Виктория", false, 64);
        Human grandMother2 = new Human("Зоя", false, 67);

        Human father = new Human("Алексей",true, 42, grandFather1, grandMother1);
        Human mother = new Human("Марина", false, 40, grandFather2, grandMother2);

        Human baby1 = new Human("Кирилл",true, 17, father, mother);
        Human baby2 = new Human("Аня", false, 13, father, mother);
        Human baby3 = new Human("Влад", true, 8, father, mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(baby1);
        System.out.println(baby2);
        System.out.println(baby3);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















