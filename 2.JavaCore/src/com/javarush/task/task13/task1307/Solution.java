package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<String>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    public static class StringObject<Object> implements SimpleObject<String> //допишите здесь ваш код
    {
        public SimpleObject<String> getInstance(){
            return new StringObject<String>();

        }
    }
}