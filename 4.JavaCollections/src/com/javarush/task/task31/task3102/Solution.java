package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        File rootDidect = new File(root);
        stack.push(rootDidect);
        while (!stack.isEmpty()) {
            File newFile = stack.pop();
            if (newFile.isDirectory()) {
                for (File f : newFile.listFiles()) {
                    stack.push(f);
                }
            }else if (newFile.isFile()){
                files.add(newFile.getAbsolutePath());
            }
        }


        return files;

    }

    public static void main(String[] args) {
        
    }
}
