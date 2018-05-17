package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //String file = "c:/test/nn.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine());
            sb.append(" ");
        }
        br.close();
        //...
        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sB = new StringBuilder();
        if (words == null || words.length == 0)
            return sB;

        List<String> wordArray = new ArrayList<>();
        for (String word: words)
            wordArray.add(word);
        Collections.sort(wordArray);
        StringBuilder newString = new StringBuilder(wordArray.get(0));
        wordArray.remove(0);

        for (int i = 0; i < wordArray.size(); i++) {
            newString.append(" " + wordArray.get(i));
            if (wordArray.get(i).substring(0,1).equalsIgnoreCase(newString.substring(newString.length() - 1))) {
                wordArray.remove(i);
                i = -1;
            }
        }
        return newString;

    }
}
