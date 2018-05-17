package com.javarush.task.task14.task1409;

public class WaterBridge implements Bridge {
    int N = 3;
    @Override
    public int getCarsCount() {
        return N;
    }
}
