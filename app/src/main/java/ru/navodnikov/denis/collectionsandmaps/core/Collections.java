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
        for (int i = 0; i < names.length; i++) {
            data.add(new BenchmarkItem(names[i], AppContext.getContext().getString(R.string.default_time), i));
        }
        return data;

    }

    @Override
    public int getSpanCount() {
        return 3;
    }

    @Override
    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements) {
        List<Integer> listOfItems;

        if (benchmarkItem.getNumberOfOperations() == 0
                || benchmarkItem.getNumberOfOperations() == 3
                || benchmarkItem.getNumberOfOperations() == 6
                || benchmarkItem.getNumberOfOperations() == 9
                || benchmarkItem.getNumberOfOperations() == 12
                || benchmarkItem.getNumberOfOperations() == 15
                || benchmarkItem.getNumberOfOperations() == 18) {
            listOfItems = new ArrayList<>(java.util.Collections.nCopies(contOfElements, 1));
        } else if (benchmarkItem.getNumberOfOperations() == 1
                || benchmarkItem.getNumberOfOperations() == 4
                || benchmarkItem.getNumberOfOperations() == 7
                || benchmarkItem.getNumberOfOperations() == 10
                || benchmarkItem.getNumberOfOperations() == 13
                || benchmarkItem.getNumberOfOperations() == 16
                || benchmarkItem.getNumberOfOperations() == 19) {
            listOfItems = new LinkedList<>(java.util.Collections.nCopies(contOfElements, 1));
        } else {
            listOfItems = new CopyOnWriteArrayList<>(java.util.Collections.nCopies(contOfElements, 1));
        }

        if (benchmarkItem.getNumberOfOperations()==0) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==1) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==2) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(0, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==3) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(listOfItems.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==4) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(listOfItems.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==5) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(listOfItems.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==6) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==7) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==8) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.add(1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==9) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==10) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==11) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.contains(2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==12) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==13) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==14) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(0);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==15) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==16) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==17) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() / 2);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==18) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==19) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        } else if (benchmarkItem.getNumberOfOperations()==20) {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                listOfItems.remove(listOfItems.size() - 1);
            }
            long endTime = System.nanoTime();
            benchmarkItem.setTime((((double) (endTime - startTime) / 1000000) + " ms"));
            return benchmarkItem;
        }

        return new BenchmarkItem("нет такого", "99999", 0);
    }
}
