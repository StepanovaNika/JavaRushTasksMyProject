package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        PersonScannerAdapter (Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String s = fileScanner.nextLine();
            String[] arr = s.split(" ");
            SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
            Date date = format.parse(arr[arr.length - 3] + arr[arr.length - 2] + arr[arr.length - 1]);
            Person person = new Person(arr[1], arr[2], arr[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
