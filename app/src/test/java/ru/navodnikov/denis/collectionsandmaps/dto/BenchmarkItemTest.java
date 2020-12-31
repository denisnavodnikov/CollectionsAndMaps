package ru.navodnikov.denis.collectionsandmaps.dto;

import org.junit.Test;

import ru.navodnikov.denis.collectionsandmaps.R;

import static org.junit.Assert.assertTrue;

public class BenchmarkItemTest {

    @Test
    public void isSame() {
        final BenchmarkItem benchmarkItemTest = new BenchmarkItem(Constants.DEFAULT_TIME, R.string.array_list, R.string.adding_to_beginning);
        final BenchmarkItem benchmarkItem = new BenchmarkItem(2, R.string.array_list, R.string.adding_to_beginning);

        assertTrue(benchmarkItemTest.isSame(benchmarkItem));
    }
}