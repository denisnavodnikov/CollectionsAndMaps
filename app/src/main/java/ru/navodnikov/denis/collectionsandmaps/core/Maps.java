package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.MapsFragment;

public class Maps implements Benchmarked {



    @Override
    public List<BenchmarkItem> getItems() {
        List<BenchmarkItem> data = new ArrayList<>();
        data.add(new BenchmarkItem("Adding to HashMap", "N/A ms"));
        data.add(new BenchmarkItem("Adding to TreeMap", "N/A ms"));
        data.add(new BenchmarkItem("Search in HashMap", "N/A ms"));
        data.add(new BenchmarkItem("Search in TreeMap", "N/A ms"));
        data.add(new BenchmarkItem("Removing from HashMap", "N/A ms"));
        data.add(new BenchmarkItem("Removing from TreeMap", "N/A ms"));
        return data;

    }

    @Override
    public int getSpanCount() {
        return 2;
    }

    @Override
    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements) {
        if(benchmarkItem.getTitle().equals("Adding to HashMap")){
            Map<Integer, Integer> hashMapAdding = new HashMap<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                hashMapAdding.put(i, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to TreeMap")){
            Map<Integer, Integer> treeMapAdding = new TreeMap<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                treeMapAdding.put(i, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in HashMap")){
            Map<Integer, Integer> hashMapSearching = new HashMap<>();
            hashMapSearching.put(0, 1);
            hashMapSearching.put(0, 2);
            hashMapSearching.put(0, 3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                hashMapSearching.containsValue(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in HashMap")){
            Map<Integer, Integer> treeMapSearching = new TreeMap<>();
            treeMapSearching.put(0, 1);
            treeMapSearching.put(0, 2);
            treeMapSearching.put(0, 3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                treeMapSearching.containsValue(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in TreeMap")){
            Map<Integer, Integer> hashMapRemoving = new HashMap<>();
            for (int i = 0; i < contOfElements; i++)
                hashMapRemoving.put(i, 1);

            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                hashMapRemoving.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from HashMap")){
            Map<Integer, Integer> hashMapRemoving = new HashMap<>();
            for (int i = 0; i < contOfElements; i++)
                hashMapRemoving.put(i, 1);

            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                hashMapRemoving.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from TreeMap")){
            Map<Integer, Integer> treeMapRemoving = new TreeMap<>();
            for (int i = 0; i < contOfElements; i++)
                treeMapRemoving.put(i, 1);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                treeMapRemoving.remove(i);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        return new BenchmarkItem("нет такого", "9999");
    }
}
