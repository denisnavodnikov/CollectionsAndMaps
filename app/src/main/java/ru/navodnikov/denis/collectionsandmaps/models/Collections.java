package ru.navodnikov.denis.collectionsandmaps.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;


public class Collections implements Benchmarked {

    @Override
    public List<BenchmarkItem> getItems() {
        List<BenchmarkItem> data = new ArrayList<>();
        int[] collections = {
                R.string.array_list,
                R.string.linked_list,
                R.string.copy_on_write_array_list,
        };
        int[] operations = {
                R.string.adding_to_beginning,
                R.string.adding_to_middle,
                R.string.adding_to_end,
                R.string.search_in_list,
                R.string.removing_from_start,
                R.string.removing_from_middle,
                R.string.removing_from_end
        };
        for (int operation : operations) {
            for (int collection : collections) {
                data.add(new BenchmarkItem(Constants.DEFAULT_TIME, collection, operation));
            }
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

        if (benchmarkItem.getIdOfCollectionsOrMaps() == R.string.array_list) {
            listOfItems = new ArrayList<>(java.util.Collections.nCopies(contOfElements, 1));
        } else if (benchmarkItem.getIdOfCollectionsOrMaps() == R.string.linked_list) {
            listOfItems = new LinkedList<>(java.util.Collections.nCopies(contOfElements, 1));
        } else {
            listOfItems = new CopyOnWriteArrayList<>(java.util.Collections.nCopies(contOfElements, 1));
        }

        if (benchmarkItem.getIdOfOperations() == R.string.adding_to_beginning) {
            long startTime = System.nanoTime();
            listOfItems.add(0, 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);


        } else if (benchmarkItem.getIdOfOperations() == R.string.adding_to_middle) {
            long startTime = System.nanoTime();
            listOfItems.add(listOfItems.size() / 2, 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);
        } else if (benchmarkItem.getIdOfOperations() == R.string.adding_to_end) {
            long startTime = System.nanoTime();
            listOfItems.add(1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        } else if (benchmarkItem.getIdOfOperations() == R.string.search_in_list) {
            listOfItems.add(new Random().nextInt(listOfItems.size() - 1), 2);
            long startTime = System.nanoTime();
            listOfItems.indexOf(2);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        } else if (benchmarkItem.getIdOfOperations() == R.string.removing_from_start) {
            long startTime = System.nanoTime();
            listOfItems.remove(0);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        } else if (benchmarkItem.getIdOfOperations() == R.string.removing_from_middle) {
            long startTime = System.nanoTime();
            listOfItems.remove(listOfItems.size() / 2);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        } else if (benchmarkItem.getIdOfOperations() == R.string.removing_from_end) {
            long startTime = System.nanoTime();
            listOfItems.remove(listOfItems.size() - 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        }
        return benchmarkItem;

    }
}
