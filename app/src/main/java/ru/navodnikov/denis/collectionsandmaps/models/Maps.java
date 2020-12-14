package ru.navodnikov.denis.collectionsandmaps.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;

public class Maps implements Benchmarked {


    @Override
    public List<BenchmarkItem> getItems() {
        List<BenchmarkItem> data = new ArrayList<>();
        int[] maps = {
                R.string.hash_map,
                R.string.tree_map,
        };
        int[] operations = {
                R.string.adding_to_Map,
                R.string.search_in_Map,
                R.string.removing_from_Map,
        };
        for (int operation : operations) {
            for (int map : maps) {
                data.add(new BenchmarkItem(Constants.DEFAULT_TIME, map, operation));
            }
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

        if (benchmarkItem.getIdOfCollectionsOrMaps() == R.string.hash_map) {
            mapOfItems = new HashMap<>();
        } else {
            mapOfItems = new TreeMap<>();
        }
        for (int i = 0; i < contOfElements; i++) {
            mapOfItems.put(i, 1);
        }

        if (benchmarkItem.getIdOfOperations() == R.string.adding_to_Map) {
            long startTime = System.nanoTime();
            mapOfItems.put(-1, 1);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        } else if (benchmarkItem.getIdOfOperations() == R.string.search_in_Map) {
            long startTime = System.nanoTime();
            mapOfItems.containsValue(2);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        } else if (benchmarkItem.getIdOfOperations() == R.string.removing_from_Map) {

            long startTime = System.nanoTime();
            mapOfItems.remove(7);
            long endTime = System.nanoTime();
            benchmarkItem.setTime((endTime - startTime) / 1000000D);

        }
        return benchmarkItem;
    }
}
