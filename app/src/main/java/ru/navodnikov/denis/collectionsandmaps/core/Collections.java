package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.CollectionsFragment;

public class Collections implements Benchmarked {


    @Override
    public List<BenchmarkItem> getItems() {
        List<BenchmarkItem> data = new ArrayList<>();
        data.add(new BenchmarkItem("Adding to start in ArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to start in LinkedList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to start in CopyOnWriteArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to middle in ArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to middle in LinkedList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to middle in CopyOnWriteArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to end in ArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to end in LinkedList", "N/A ms"));
        data.add(new BenchmarkItem("Adding to end in CopyOnWriteArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Search in ArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Search in LinkedList", "N/A ms"));
        data.add(new BenchmarkItem("Search in CopyOnWriteArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from start in ArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from start in LinkedList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from start in CopyOnWriteArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from middle in ArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from middle in LinkedList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from middle in CopyOnWriteArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from end in ArrayList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from end in LinkedList", "N/A ms"));
        data.add(new BenchmarkItem("Removing from end in CopyOnWriteArrayList", "N/A ms"));
        return data;

    }

    @Override
    public int getSpanCount() {
        return 3;
    }

    @Override
    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements) {
        if(benchmarkItem.getTitle().equals("Adding to start in ArrayList")){
            List<Integer> arrayListAddingStart = new ArrayList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListAddingStart.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to start in LinkedList")){
            List<Integer> linkedListAddingStart = new LinkedList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListAddingStart.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to start in CopyOnWriteArrayList")){
            List<Integer> CopyOnWriteArrayListAddingStart = new CopyOnWriteArrayList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListAddingStart.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to middle in ArrayList")){
            List<Integer> arrayListAddingMiddle = new ArrayList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListAddingMiddle.add(arrayListAddingMiddle.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to middle in LinkedList")){
            List<Integer> linkedListAddingMiddle = new LinkedList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListAddingMiddle.add(linkedListAddingMiddle.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to middle in CopyOnWriteArrayList")){
            List<Integer> CopyOnWriteArrayListAddingMiddle = new CopyOnWriteArrayList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListAddingMiddle.add(CopyOnWriteArrayListAddingMiddle.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to end in ArrayList")){
            List<Integer> arrayListAddingEnd = new ArrayList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListAddingEnd.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to end in LinkedList")){
            List<Integer> linkedListAddingEnd = new LinkedList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListAddingEnd.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to end in CopyOnWriteArrayList")){
            List<Integer> CopyOnWriteArrayListAddingEnd = new CopyOnWriteArrayList<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListAddingEnd.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in ArrayList")){
            List<Integer> arrayListSearch = new ArrayList<>();
            arrayListSearch.add(1);
            arrayListSearch.add(2);
            arrayListSearch.add(3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListSearch.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in LinkedList")){
            List<Integer> linkedListSearch = new LinkedList<>();
            linkedListSearch.add(1);
            linkedListSearch.add(2);
            linkedListSearch.add(3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListSearch.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in CopyOnWriteArrayList")){
            List<Integer> CopyOnWriteArrayListSearch = new CopyOnWriteArrayList<>();
            CopyOnWriteArrayListSearch.add(1);
            CopyOnWriteArrayListSearch.add(2);
            CopyOnWriteArrayListSearch.add(3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListSearch.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from start in ArrayList")){
            List<Integer> arrayListRemovingStart = new ArrayList<>();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingStart.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingStart.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from start in LinkedList")){
            List<Integer> linkedListRemovingStart = new LinkedList<>();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingStart.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingStart.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from start in CopyOnWriteArrayList")){
            List<Integer> CopyOnWriteArrayListRemovingStart = new CopyOnWriteArrayList<>();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingStart.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingStart.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from middle in ArrayList")){
            List<Integer> arrayListRemovingMiddle = new ArrayList<>();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingMiddle.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingMiddle.remove(arrayListRemovingMiddle.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from middle in LinkedList")){
            List<Integer> linkedListRemovingMiddle = new LinkedList<>();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingMiddle.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingMiddle.remove(linkedListRemovingMiddle.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from middle in CopyOnWriteArrayList")){
            List<Integer> CopyOnWriteArrayListRemovingMiddle = new CopyOnWriteArrayList<>();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingMiddle.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingMiddle.remove(CopyOnWriteArrayListRemovingMiddle.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from end in ArrayList")){
            List<Integer> arrayListRemovingEnd = new ArrayList<>();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingEnd.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingEnd.remove(arrayListRemovingEnd.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from end in LinkedList")){
            List<Integer> linkedListRemovingEnd = new LinkedList<>();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingEnd.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingEnd.remove(linkedListRemovingEnd.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from end in CopyOnWriteArrayList")){
            List<Integer> CopyOnWriteArrayListRemovingEnd = new CopyOnWriteArrayList<>();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingEnd.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingEnd.remove(CopyOnWriteArrayListRemovingEnd.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }

        return new BenchmarkItem("нет такого", "99999");
    }
}
