package com.javarush.task.task14.task1408;

import java.util.HashMap;

public class BelarusianHen extends Hen {
    int N = 1;
    String country = Country.BELARUS;
    @Override
    int getCountOfEggsPerMonth() {
        return N;
    }
    public String getDescription(){
        return super.getDescription() + " " + "Моя страна - " + country + ". Я несу " +  getCountOfEggsPerMonth() + " яиц в месяц.";


    }
}
