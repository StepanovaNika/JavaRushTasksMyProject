package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.indexOf("?") + 1;
        String sub = url.substring(index);
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> alertList = new ArrayList<String>();
        String[] strings = sub.split("&");
        for (String s : strings)
        {
            if (s.contains("="))
            {
                String[] splitS = s.split("=");
                String pAlert = splitS[0];
                list.add(pAlert);
                if (pAlert.equals("obj"))
                    alertList.add(splitS[1]);
            } else
                list.add(s);


            //add your code here
        }
        for (String s : list)
        {
            System.out.print(s + " ");
        }
        System.out.println("");
        for (String s : alertList)
        {
            try
            {
                alert(Double.parseDouble(s));
            }
            catch (Exception e)
            {
                alert(s);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
