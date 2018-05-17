package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String s = "abcdefghijklmnopqrstuvwxyz";
        String dig = "1234567890";
        StringBuffer pass = new StringBuffer();

        for (int i = 0; i < 2; i++){
            pass.append(dig.charAt((int) (Math.random() * 10)));
        }
        for (int i = 0; i < 4; i++){
            pass.append(s.charAt((int) (Math.random() * 26)));
        }
        for (int i = 0; i < 2; i++){
            pass.append(s.toUpperCase().charAt((int) (Math.random() * 26)));

        }

        try {
            byteArrayOutputStream.write(pass.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream;
    }
}