package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.rmi.RemoteException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends RemoteException{
    }

    static class MyException2 extends NoSuchFieldException{
    }

    static class MyException3 extends NumberFormatException{
    }

    static class MyException4 extends IndexOutOfBoundsException{
    }
}

