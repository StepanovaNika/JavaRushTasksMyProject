package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){

        List<Advertisement> availableVideos = storage.list();
        if (availableVideos.isEmpty()) throw new NoVideoAvailableException();
        List<Advertisement> availableVideosToShow = new ArrayList<>();
        for (Advertisement ad : availableVideos) { if (ad.getDuration() <= timeSeconds && ad.getHits() > 0) availableVideosToShow.add(ad); }
        if (availableVideosToShow.isEmpty()) throw new NoVideoAvailableException();

        List<Advertisement> videosToShow = getVideosToShow(availableVideosToShow);

        Collections.sort(videosToShow, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long amountO1 = o1.getAmountPerOneDisplaying();
                long amountO2 = o2.getAmountPerOneDisplaying();

                if (!((amountO1 - amountO2) == 0)) {
                    return (amountO2 -  amountO1) > 0 ? 1 : -1;
                } else {
                    long pricePerSecO1 = amountO1/o1.getDuration();
                    long pricePerSecO2 = amountO2/o2.getDuration();

                    if (!((pricePerSecO1 - pricePerSecO2) == 0)) {
                        return (pricePerSecO2 - pricePerSecO1) > 0 ? 1 : -1;
                    } else return 0;
                }
            }
        });

        if (videosToShow.isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
        } else {
            long totalAmount = 0;
            int totalDuration = 0;
            for (Advertisement ad : videosToShow) {
                totalAmount += ad.getAmountPerOneDisplaying();
                totalDuration += ad.getDuration();
            }

            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(videosToShow, totalAmount, totalDuration));
        }

        for (Advertisement ad : videosToShow) {
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", " + ad.getAmountPerOneDisplaying()*1000/(long)ad.getDuration());
            ad.revalidate();
        }
    }

    private List<Advertisement> getVideosToShow(List<Advertisement> availableVideos) {
        List<List<Advertisement>> listOfLists = new ArrayList<>();

        for (Advertisement AD : availableVideos) {
            List<Advertisement> tempList = new ArrayList<>();
            tempList.add(AD);
            listOfLists.add(tempList);
        }

        int i = 0;
        while (i < listOfLists.size()) {
            for (Advertisement AD : availableVideos) {
                if (listOfLists.get(i).contains(AD))
                    continue;

                int thisDuration = AD.getDuration();
                for (Advertisement ad : listOfLists.get(i))
                    thisDuration += ad.getDuration();

                if (thisDuration <= timeSeconds) {
                    List<Advertisement> tempList = new ArrayList<>();
                    tempList.addAll(listOfLists.get(i));
                    tempList.add(AD);
                    listOfLists.add(tempList);
                }
            }
            i++;
        }

        if (listOfLists.isEmpty()) return null;

        int maxPrice = 0;
        int maxDuration;
        List<Advertisement> bestList = null;

        for (List<Advertisement> list : listOfLists) {
            if (list.isEmpty()) continue;

            int thisPrice = 0;
            for(Advertisement AD : list) {
                thisPrice += AD.getAmountPerOneDisplaying();
            }

            if (thisPrice > maxPrice) {
                bestList = list;
                maxPrice = thisPrice;
            }
            else {
                if (thisPrice == maxPrice) {
                    if (bestList == null) {
                        bestList = list;
                    } else {
                        int thisDuration = 0;
                        for (Advertisement AD : list) {
                            thisDuration += AD.getDuration();
                        }

                        maxDuration = 0;
                        for (Advertisement AD : bestList) {
                            maxDuration += AD.getDuration();
                        }

                        if (maxDuration < thisDuration)
                            bestList = list;
                        else {
                            if (maxDuration == thisDuration) {
                                if (bestList.size() > list.size())
                                    bestList = list;
                            }
                        }
                    }
                }
            }
        }
        return bestList;    }

}
