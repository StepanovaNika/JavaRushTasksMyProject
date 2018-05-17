package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    int N = 3;
    String country = Country.UKRAINE;

    @Override
    int getCountOfEggsPerMonth() {
        return N;
    }

    public String getDescription() {
        return super.getDescription() + " " + "Моя страна - " + country + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

    }
}
