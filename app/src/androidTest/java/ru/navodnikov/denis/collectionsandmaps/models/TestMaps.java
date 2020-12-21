package ru.navodnikov.denis.collectionsandmaps.models;

import java.util.ArrayList;
import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;

public class TestMaps implements Benchmarked {


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

        benchmarkItem.setTime(2.0);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return benchmarkItem;
    }
}
