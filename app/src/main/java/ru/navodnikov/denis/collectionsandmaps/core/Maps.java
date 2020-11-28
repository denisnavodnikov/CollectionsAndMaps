package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

        if (benchmarkItem.getNumberOfOperations() % 2 == 0) {
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


        if (benchmarkItem.getNumberOfOperations() < 2) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.put(i, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + AppContext.getContext().getResources().getString(R.string.ms)));

        } else if (benchmarkItem.getNumberOfOperations() > 1 && benchmarkItem.getNumberOfOperations() < 4) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.containsValue(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + AppContext.getContext().getResources().getString(R.string.ms)));

        } else if (benchmarkItem.getNumberOfOperations() > 3) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + AppContext.getContext().getResources().getString(R.string.ms)));

        }
        return benchmarkItem;
    }
}
