package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream cons = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        String text = outputStream.toString();
        fileOutputStream.write(text.getBytes());
        System.setOut(cons);

        System.out.println(text);
        reader.close();
        fileOutputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

