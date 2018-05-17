package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);

    }

    public static String readString() throws IOException {
        String s = reader.readLine();
        return s;

    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> order = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        while (true) {
            System.out.println("Введите название блюда");
            String answer = readString();
            if (answer.equals("exit"))
                break;
            else {
                switch (answer) {
                    case "Fish":
                    case "Steak":
                    case "Soup":
                    case "Juice":
                    case "Water":
                        order.add(Dish.valueOf(answer));
                        break;
                    default: writeMessage("Такого блюда нет в меню."); break;
                }
            }
        }
        return order;

    }
}
