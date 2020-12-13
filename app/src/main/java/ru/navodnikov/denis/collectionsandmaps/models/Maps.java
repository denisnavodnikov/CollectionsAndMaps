package ru.navodnikov.denis.collectionsandmaps.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;

public class Maps implements Benchmarked {


    @Override
    public List<BenchmarkItem> getItems() {
        List<BenchmarkItem> data = new ArrayList<>();
        for (int i = 0; i < Constants.QUANTITY_OF_MAPS; i++) {
            data.add(new BenchmarkItem( Constants.DEFAULT_TIME, i));
        }
        return data;

    }

    @Override
    public int getSpanCount() {
        return 2;
    }

    @Override
    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements) {

        Map<Integer, Integer> mapOfItems;

        if (benchmarkItem.getNumberOfOperations() % 2 == 0) {
            mapOfItems = new HashMap<>();
        } else {
            mapOfItems = new TreeMap<>();
        }
        for (int i = 0; i < contOfElements; i++) {
            mapOfItems.put(i, 1);
        }

        if (benchmarkItem.getNumberOfOperations() < 2) {
            long startTime = System.nanoTime();
            mapOfItems.put(-1, 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((double)(endTime - startTime) / 1000000);

        } else if (benchmarkItem.getNumberOfOperations() > 1 && benchmarkItem.getNumberOfOperations() < 4) {
            long startTime = System.nanoTime();
            mapOfItems.containsValue(2);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((double)(endTime - startTime) / 1000000);

        } else if (benchmarkItem.getNumberOfOperations() > 3) {

            long startTime = System.nanoTime();
            mapOfItems.remove(7);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((double)(endTime - startTime) / 1000000);

        }
        return benchmarkItem;
    }
}
