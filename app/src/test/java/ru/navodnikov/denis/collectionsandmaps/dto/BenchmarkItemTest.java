package ru.navodnikov.denis.collectionsandmaps.dto;

import org.junit.After;
import org.junit.Test;

import ru.navodnikov.denis.collectionsandmaps.R;

import static org.junit.Assert.assertEquals;

public class BenchmarkItemTest {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isSame() {
        int testTime = 2;
        BenchmarkItem benchmarkItemTest = new BenchmarkItem(Constants.DEFAULT_TIME, R.string.array_list, R.string.adding_to_beginning);
        BenchmarkItem benchmarkItem = new BenchmarkItem(testTime, R.string.array_list, R.string.adding_to_beginning);
        benchmarkItemTest.isSame(benchmarkItem);

        assertEquals(benchmarkItem.getTime(), benchmarkItemTest.getTime(), 0.0001);
    }
}