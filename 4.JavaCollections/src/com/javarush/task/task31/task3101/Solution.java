package com.javarush.task.task31.task3101;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
   public static List<File> files = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newFile;
        if (resultFileAbsolutePath.getParent() == null){
            newFile = new File("allFilesContent.txt");
        }else
            newFile = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, newFile);
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        scanDirect(path);

        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (File filess : files){
            FileInputStream inputStream = new FileInputStream(filess);
            while (inputStream.available() > 0){
                fileOutputStream.write(inputStream.read());
            }
            fileOutputStream.write('\n');
            fileOutputStream.flush();
            inputStream.close();
        }
        fileOutputStream.close();
    }

    public static void scanDirect(File file){
        for (File file1 : file.listFiles()){
            if (file1.isDirectory())
                scanDirect(file1);
            if (file1.isFile()){
                if (file1.length() > 50){
                    FileUtils.deleteFile(file1);
                }
                else
                    files.add(file1);
            }
        }
    }
    public static void deleteFile(File file) {
        if (!file.delete())
            System.out.println("Can not delete file with name " + file.getName());
    }
}
