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
        for (String name : names){
            data.add(new BenchmarkItem(name, AppContext.getContext().getString(R.string.default_time)));
        }
        return data;

    }

    @Override
    public int getSpanCount() {
        return 2;
    }

    @Override
    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements) {

        Map<Integer, Integer> mapOfItems = new HashMap<>();
        for (int i = 0; i < contOfElements; i++) {
            mapOfItems.put(i, 1);
        }
        if (benchmarkItem.getTitle().contains("TreeMap")){
            mapOfItems = new TreeMap<>();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.put(i, 1);
            }
        }


        if(benchmarkItem.getTitle().equals("Adding to HashMap")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.put(i, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to TreeMap")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.put(i, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in HashMap")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.containsValue(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in HashMap")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.containsValue(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in TreeMap")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from HashMap")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from TreeMap")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                mapOfItems.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        return new BenchmarkItem("нет такого", "9999");
    }
}
