package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        T res = null;
        ObjectMapper mapper = new ObjectMapper();
        res = mapper.readValue(new FileReader(new File(fileName)), clazz);
        return res;
    }

    public static void main(String[] args) {

    }
}
