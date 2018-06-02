package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;
import java.util.List;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = new Character('%');
        System.out.println((Long) object);

    }

    public void methodThrowsNullPointerException() {
        List<String> list = new ArrayList<>();
        list = null;
        list.size();

    }

    public static void main(String[] args) {

    }
}
