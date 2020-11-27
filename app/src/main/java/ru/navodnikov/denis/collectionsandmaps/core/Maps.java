package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.ui.AppContext;

public class Maps implements Benchmarked {


    @Override
    public List<BenchmarkItem> getItems() {
        List<BenchmarkItem> data = new ArrayList<>();
        String[] names = AppContext.getContext().getResources().getStringArray(R.array.names_maps_list);
        for (int i = 0; i < names.length; i++) {
            data.add(new BenchmarkItem(names[i], AppContext.getContext().getString(R.string.default_time), i));
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

        if (benchmarkItem.getNumberOfOperations() == 0
                || benchmarkItem.getNumberOfOperations() == 2
                || benchmarkItem.getNumberOfOperations() == 4) {
            mapOfItems = new HashMap<>();
        } else {
            mapOfItems = new TreeMap<>();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.put(i, 1);
            }
        }

        for (int i = 0; i < contOfElements; i++) {
            mapOfItems.put(i, 1);
        }


        if (benchmarkItem.getNumberOfOperations() == 0) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.put(i, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations() == 1) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.put(i, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations() == 2) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.containsValue(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations() == 3) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations() == 4) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations() == 5) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        return new BenchmarkItem("нет такого", "9999", 0);
    }
}
