package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.ui.AppContext;

public class Collections implements Benchmarked {


    @Override
    public List<BenchmarkItem> getItems() {
        List<BenchmarkItem> data = new ArrayList<>();
        String[] names = AppContext.getContext().getResources().getStringArray(R.array.names_collections_list);
        for (String name : names){
            data.add(new BenchmarkItem(name, AppContext.getContext().getString(R.string.default_time)));
        }
        return data;

    }

    @Override
    public int getSpanCount() {
        return 3;
    }

    @Override
    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements) {
        List<Integer> listOfItems = new ArrayList<>();
        for (int i = 0; i < contOfElements; i++) {
            listOfItems.add(1);
        }
        if (benchmarkItem.getTitle().contains("LinkedList")){
            listOfItems = new LinkedList<>();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
        }
        else if (benchmarkItem.getTitle().contains("CopyOnWriteArrayList")){
            listOfItems = new CopyOnWriteArrayList<>();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
        }

        if(benchmarkItem.getTitle().equals("Adding to start in ArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to start in LinkedList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to start in CopyOnWriteArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to middle in ArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(listOfItems.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to middle in LinkedList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(listOfItems.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to middle in CopyOnWriteArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(listOfItems.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to end in ArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to end in LinkedList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Adding to end in CopyOnWriteArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in ArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in LinkedList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Search in CopyOnWriteArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from start in ArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from start in LinkedList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from start in CopyOnWriteArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from middle in ArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from middle in LinkedList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from middle in CopyOnWriteArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from end in ArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from end in LinkedList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }
        else if(benchmarkItem.getTitle().equals("Removing from end in CopyOnWriteArrayList")){
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }

        return new BenchmarkItem("нет такого", "99999");
    }
}
