package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader rd = new BufferedReader(new FileReader(file1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(file2));
        String s;
        ArrayList<String> list = new ArrayList<>();

        while ((s = rd.readLine())!=null)
        {
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++)
        {
            String[] arr =list.get(i).split(" ");
            for (int j = 0; j < arr.length; j++)
            {
                try
                {
                    int tmp = Integer.parseInt(arr[j]);
                    fw.write(arr[j]);
                    fw.write(" ");
                }
                catch (Exception e)
                {

                }
            }
        }
        rd.close();
        fw.close();


    }
}
