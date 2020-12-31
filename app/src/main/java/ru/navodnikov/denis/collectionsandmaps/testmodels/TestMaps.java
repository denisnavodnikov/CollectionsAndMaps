package ru.navodnikov.denis.collectionsandmaps.testmodels;

import java.util.ArrayList;
import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;
import ru.navodnikov.denis.collectionsandmaps.models.Maps;

public class TestMaps extends Maps {



    @Override
    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements) {


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        benchmarkItem.setTime(2.0);
        return benchmarkItem;
    }
}
