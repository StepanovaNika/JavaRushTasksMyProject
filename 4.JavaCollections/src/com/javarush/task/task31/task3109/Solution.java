package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        boolean isfileXml;
try {
    FileInputStream fileInputStream = new FileInputStream(fileName);
    properties.loadFromXML(fileInputStream);
    isfileXml = true;
}catch (IOException e){
    isfileXml = false;
}
if (!isfileXml){
    FileInputStream fileInputStream;
    try {
        fileInputStream = new FileInputStream(fileName);
        properties.load(fileInputStream);
        fileInputStream.close();
    }catch (IOException e){

    }

}return properties;
    }
}
