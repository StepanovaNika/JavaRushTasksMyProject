package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.bin"));
        Solution savedObject = new Solution(4);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.flush();
        objectOutputStream.close();

        Solution loadedObject = new Solution(8);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.bin"));
        loadedObject = (Solution) objectInputStream.readObject();
        System.out.println(loadedObject);

        if (savedObject.string.equals(loadedObject.string))
            System.out.println("Strings are equal");


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
