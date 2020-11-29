package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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

        if (benchmarkItem.getNumberOfOperations() % 3 == 0) {
            listOfItems = new ArrayList<>(java.util.Collections.nCopies(contOfElements, 1));
        } else if (benchmarkItem.getNumberOfOperations() % 3 == 1) {
            listOfItems = new LinkedList<>(java.util.Collections.nCopies(contOfElements, 1));
        } else {
            listOfItems = new CopyOnWriteArrayList<>(java.util.Collections.nCopies(contOfElements, 1));
        }

        if (benchmarkItem.getNumberOfOperations() < 3) {
            long startTime = System.nanoTime();
            listOfItems.add(0, 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime(AppContext.getContext().getResources().getString(R.string.result, ((double) (endTime - startTime) / 1000000)));


        } else if (benchmarkItem.getNumberOfOperations() > 2 && benchmarkItem.getNumberOfOperations() < 6) {
            long startTime = System.nanoTime();
            listOfItems.add(listOfItems.size() / 2, 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime(AppContext.getContext().getResources().getString(R.string.result, ((double) (endTime - startTime) / 1000000)));

        } else if (benchmarkItem.getNumberOfOperations() > 5 && benchmarkItem.getNumberOfOperations() < 9) {
            long startTime = System.nanoTime();
            listOfItems.add(1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime(AppContext.getContext().getResources().getString(R.string.result, ((double) (endTime - startTime) / 1000000)));

        } else if (benchmarkItem.getNumberOfOperations() > 8 && benchmarkItem.getNumberOfOperations() < 12) {
            listOfItems.add(new Random().nextInt(listOfItems.size()), 2);
            long startTime = System.nanoTime();
            listOfItems.indexOf(2);
            long endTime = System.nanoTime();
            benchmarkItem.setTime(AppContext.getContext().getResources().getString(R.string.result, ((double) (endTime - startTime) / 1000000)));

        } else if (benchmarkItem.getNumberOfOperations() > 11 && benchmarkItem.getNumberOfOperations() < 15) {
            long startTime = System.nanoTime();
            listOfItems.remove(0);
            long endTime = System.nanoTime();
            benchmarkItem.setTime(AppContext.getContext().getResources().getString(R.string.result, ((double) (endTime - startTime) / 1000000)));

        } else if (benchmarkItem.getNumberOfOperations() > 14 && benchmarkItem.getNumberOfOperations() < 18) {
            long startTime = System.nanoTime();
            listOfItems.remove(listOfItems.size() / 2);
            long endTime = System.nanoTime();
            benchmarkItem.setTime(AppContext.getContext().getResources().getString(R.string.result, ((double) (endTime - startTime) / 1000000)));

        } else if (benchmarkItem.getNumberOfOperations() > 17) {
            long startTime = System.nanoTime();
            listOfItems.remove(listOfItems.size() - 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime(AppContext.getContext().getResources().getString(R.string.result, ((double) (endTime - startTime) / 1000000)));

        }
        return benchmarkItem;

    }
}
