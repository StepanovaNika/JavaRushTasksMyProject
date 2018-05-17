package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    int N = 2;
    String country = Country.RUSSIA;

    @Override
    int getCountOfEggsPerMonth() {
        return N;
    }

    public String getDescription() {
        return super.getDescription() + " " +"Моя страна - " + country + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

    }
}
