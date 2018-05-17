package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args)
    {
    }

    public static class Human {
        private String name;
        private String lastname;
        private int age;
        private String sex;
        private int weight;
        private int height;

        //1
        public Human(String name){
            this.name = name;
        }
        //2
        public Human(String name, String lastname){
            this.name = name;
            this.lastname = lastname;
        }
        //3
        public Human(String name, String lastname, int age){
            this.name = name;
            this.lastname = lastname;
            this.age = age;
        }
        //4
        public Human(String name, int age, String sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        //5
        public Human(String name, String lastname, String sex){
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
        }
        //6
        public Human(String lastname, int age, int height){
            this.lastname = lastname;
            this.age = age;
            this.height = height;
        }
        //7
        public Human(int age, int height, int weight ){
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
        //8

        public Human(String name, String lastname, int age, int weight){
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.weight = weight;
        }
        public Human( int weight, int height){
            this.weight = weight;
            this.height = height;
        }
        //10
        public Human(String name, String lastname, int age, int weight, int height){
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }



    }

}
