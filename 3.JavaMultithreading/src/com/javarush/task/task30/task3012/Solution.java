package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int[] arr={1, 3, 9, 27, 81, 243, 729, 2187};
        String s="";
        int n = number;
        while (n>0)
        {
            if (n%3==0)
            {
                s=s+"0";
                n/=3;
            }
            else if (n%3==1)
            {
                s=s+"+";
                n/=3;
            }
            else if (n%3==2)
            {
                s = s + "-";
                n/=3;
                n++;
            }
        }
        int sum=0;
        String str="";
        for (int i=0;i<s.length(); i++)
        {
            if (s.charAt(i)=='+') {
                str += " + " + arr[i];
                sum += arr[i];
            }
            else if (s.charAt(i)=='-')
            {
                str += " - "+arr[i];
                sum -= arr[i];
            }
        }
        System.out.println(sum + " =" + str);

    }
}