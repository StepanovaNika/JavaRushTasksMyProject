package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 10;
        for (int i = 1; i <= 10; i++){
            for (int j = a; j <= 10; j++){
                System.out.print("8");
            }
            System.out.println();
            a--;
        }

    }
}
