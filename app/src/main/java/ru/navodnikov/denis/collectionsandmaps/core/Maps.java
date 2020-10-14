package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.MapsFragment;

public class Maps {
    public int contOfElements;
    public int contOfThreads;

    public Maps(int contOfElements, int contOfThreads) {
        this.contOfElements = contOfElements;
        this.contOfThreads = contOfThreads;
    }

    static Map<Integer,Integer> hashMapAdding = new HashMap<>();
    static Map<Integer,Integer> treeMapAdding = new TreeMap<>();

    static Map<Integer,Integer> hashMapSearching = new HashMap<>();
    static Map<Integer,Integer> treeMapSearching = new TreeMap<>();

    static Map<Integer,Integer> hashMapRemoving = new HashMap<>();
    static Map<Integer,Integer> treeMapRemoving = new TreeMap<>();

    public void mapsOperations() {
        ExecutorService threadPool = Executors.newFixedThreadPool(contOfThreads);
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                hashMapAdding.put(i, 1);
            }
            long endTime = System.nanoTime();
            MapsFragment.listOfMaps.get(0).setTime((((double) (endTime-startTime)/1000000)+" ms"));
        });

        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                treeMapAdding.put(i, 1);
            }
            long endTime = System.nanoTime();
            MapsFragment.listOfMaps.get(1).setTime((((double) (endTime-startTime)/1000000)+" ms"));
        });

        threadPool.execute(() -> {
            hashMapSearching.put(0,1);
            hashMapSearching.put(0,2);
            hashMapSearching.put(0,3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                hashMapSearching.containsValue(2);
            }
            long endTime = System.nanoTime();
            MapsFragment.listOfMaps.get(2).setTime((((double) (endTime-startTime)/1000000)+" ms"));
        });

        threadPool.execute(() -> {
            treeMapSearching.put(0,1);
            treeMapSearching.put(0,2);
            treeMapSearching.put(0,3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                treeMapSearching.containsValue(2);
            }
            long endTime = System.nanoTime();
            MapsFragment.listOfMaps.get(3).setTime((((double) (endTime-startTime)/1000000)+" ms"));
        });

        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++)
                hashMapRemoving.put(i,1);

            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                hashMapRemoving.remove(i);
            }
            long endTime = System.nanoTime();
            MapsFragment.listOfMaps.get(4).setTime((((double) (endTime-startTime)/1000000)+" ms"));
        });

        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++)
                treeMapRemoving.put(i,1);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                treeMapRemoving.remove(i);
            }
            long endTime = System.nanoTime();
            MapsFragment.listOfMaps.get(5).setTime((((double) (endTime-startTime)/1000000)+" ms"));
        });
    }
}
