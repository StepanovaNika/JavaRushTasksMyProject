package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        //int countN = telNumber.replaceAll("\\D", "").length();
        if (telNumber == null)
            return false;
        String s = "";
        if (telNumber.equals(s))
            return false;
        if (telNumber.isEmpty())
            return false;

        /*//1
        if (telNumber.matches("^\\+.+") && countN != 12)
            return false;
        //2
        if (telNumber.matches("^[0-9].+") && countN != 10)
            return false;
        if (telNumber.matches("^\\(.+") && countN != 10)
            return false;
        //3
        if (telNumber.matches("^.+-{2,}.*"))
            return false;
        if(telNumber.matches("(.+-.+){3}"))
            return false;
        if(telNumber.matches(".+-$"))
            return false;
        //4
        if(telNumber.matches(".*\\(.*") || telNumber.matches(".*\\).*"))
            return false;
        //5
            if (telNumber.matches("\\+?\\d*\\([0-9]{3}\\).+"))
                return false;
        //6
        if (telNumber.matches(".*[a-z].*"))
            return false;
        //7
        if (!telNumber.matches(".*[0-9]$"))
            return false;

        return true;*/
        return ((telNumber.matches("^\\+[(\\-]?(\\d[\\(\\)\\-]?){11}\\d$") || telNumber.matches("^\\(?(\\d[\\-]?){9}\\d$"))
                && telNumber.matches("[+]?\\d*(\\(\\d{3}\\))?\\d*-?\\d*-?\\d*\\d$"));
    }

    public static void main(String[] args) {
        String[] s = {
                "",
                "+380501234567",
                "+38(050)1234567",
                "+38050123-45-67",
                "050123-4567",
                "+38)050(1234567",
                "+38(050)1-23-45-6-7",
                "050ххх4567",
                "050123456",
                "(0)501234567",
        };

        for (String t : s) System.out.printf("%25s :   %5s %n",t,checkTelNumber(t));


    }
}
