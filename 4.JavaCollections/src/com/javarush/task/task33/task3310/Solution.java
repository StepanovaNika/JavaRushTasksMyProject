package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String s : strings) {
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long key : keys) {
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);


        Set<Long> idSet;
        Date dateTime1 = new Date();
        idSet = getIds(shortener, set);
        Date time1 = new Date();
        long msDelay1 = time1.getTime() - dateTime1.getTime();
        Helper.printMessage(Long.toString(msDelay1));


        Set<String> stringSet;
        Date dateTime2 = new Date();
        stringSet = getStrings(shortener, idSet);
        Date time2 = new Date();
        long msDelay2 = time2.getTime() - dateTime2.getTime();
        Helper.printMessage(Long.toString(msDelay2));

        if (set.equals(stringSet)) {
            Helper.printMessage("Тест пройден.");
        } else
            Helper.printMessage("Тест не пройден.");
    }

    public static void main(String[] args) {
        StorageStrategy storageStrategy = new HashMapStorageStrategy();
        testStrategy(storageStrategy, 10000);
        OurHashMapStorageStrategy storageStrategy1 = new OurHashMapStorageStrategy();
        testStrategy(storageStrategy1, 10000);
        FileStorageStrategy storageStrategy2 = new FileStorageStrategy();
        testStrategy(storageStrategy2, 200);
        OurHashBiMapStorageStrategy storageStrategy3 = new OurHashBiMapStorageStrategy();
        testStrategy(storageStrategy3, 5000);
        HashBiMapStorageStrategy storageStrategy4 = new HashBiMapStorageStrategy();
        testStrategy(storageStrategy4, 1000);
        DualHashBidiMapStorageStrategy storageStrategy5 = new DualHashBidiMapStorageStrategy();
        testStrategy(storageStrategy5, 1000);

    }
}
