package ru.navodnikov.denis.collectionsandmaps.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CollectionsTest {private final double time = 0.111;
    private final int numberOfOperations = 0;
    private final int elementsCount = 100000;
    private Collections collections;


    @Before
    public void setUp() {
        collections = new Collections();
    }

    @Test
    public void getItems() {
        List<BenchmarkItem> items = collections.getItems();
        for (int i = 0; i < items.size(); i++) {
            assertEquals(items.get(i).getNumberOfOperations(),i);
        }

    }

    @Test
    public void getSpanCount() {
        assertEquals(3, collections.getSpanCount());
    }

    @Test
    public void getSpanCountIsNotNull() {
        assertNotNull(collections.getSpanCount());
    }

    @Test
    public void measureTime() {
        assertFalse(collections.measureTime(new BenchmarkItem(time, numberOfOperations), elementsCount).getTime()==(time));
    }
}