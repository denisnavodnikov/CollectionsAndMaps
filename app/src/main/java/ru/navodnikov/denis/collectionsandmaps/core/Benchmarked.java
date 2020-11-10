package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public interface Benchmarked {
    List<BenchmarkItem> getItems();
    int getSpanCount();
    BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int contOfElements);
}
