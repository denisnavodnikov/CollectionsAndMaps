package ru.navodnikov.denis.collectionsandmaps.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class MapsTest {

    private Maps maps;
    private final int elementsCount = 100000;


    @Before
    public void setUp() {
        maps = new Maps();
    }

    @Test
    public void getItems_IsItemOnPosition_True() {
        List<BenchmarkItem> items = maps.getItems();
        assertEquals(6, items.size());

        assertEquals(items.get(0).getIdOfCollectionsOrMaps(), R.string.hash_map);
        assertEquals(items.get(1).getIdOfCollectionsOrMaps(), R.string.tree_map);
        assertEquals(items.get(2).getIdOfCollectionsOrMaps(), R.string.hash_map);
        assertEquals(items.get(3).getIdOfCollectionsOrMaps(), R.string.tree_map);
        assertEquals(items.get(4).getIdOfCollectionsOrMaps(), R.string.hash_map);
        assertEquals(items.get(5).getIdOfCollectionsOrMaps(), R.string.tree_map);

        assertEquals(items.get(0).getIdOfOperations(), R.string.adding_to_Map);
        assertEquals(items.get(1).getIdOfOperations(), R.string.adding_to_Map);
        assertEquals(items.get(2).getIdOfOperations(), R.string.search_in_Map);
        assertEquals(items.get(3).getIdOfOperations(), R.string.search_in_Map);
        assertEquals(items.get(4).getIdOfOperations(), R.string.removing_from_Map);
        assertEquals(items.get(5).getIdOfOperations(), R.string.removing_from_Map);

    }

    @Test
    public void getSpanCount_Two() {
        assertEquals(2, maps.getSpanCount());
    }


    @Test
    public void measureTime_IsChangeTime_False() {
        assertFalse(maps.measureTime(new BenchmarkItem(Constants.DEFAULT_TIME, R.string.hash_map, R.string.adding_to_Map), elementsCount).getTime() == Constants.DEFAULT_TIME);

    }
}