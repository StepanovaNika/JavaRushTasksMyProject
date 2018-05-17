package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstline = reader.readLine();
            String twoline = reader.readLine();
            BufferedReader fReader1 = new BufferedReader(new FileReader(new File(firstline)));
            String s;
            while ((s = fReader1.readLine()) != null)
                allLines.add(s);
                fReader1.close();
            BufferedReader fReader2 = new BufferedReader(new FileReader(new File(twoline)));
            while ((s = fReader2.readLine()) != null)
                forRemoveLines.add(s);
                fReader2.close();
            reader.close();
        new Solution().joinData();
        }catch (Exception e){}

    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
