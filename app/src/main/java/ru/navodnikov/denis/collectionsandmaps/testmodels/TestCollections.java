package ru.navodnikov.denis.collectionsandmaps.testmodels;

import java.util.ArrayList;
import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;
import ru.navodnikov.denis.collectionsandmaps.models.Collections;


public class TestCollections extends Collections {

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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        benchmarkItem.setTime(3.0);
        return benchmarkItem;

    }
}
