package ru.navodnikov.denis.collectionsandmaps.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CollectionsTest {
    private final int elementsCount = 100000;
    private Collections collections;


    @Before
    public void setUp() {
        collections = new Collections();
    }

    @Test
    public void getItems_IsItemOnPosition_True() {
        List<BenchmarkItem> items = collections.getItems();
        assertEquals(items.size(), 21);
        assertEquals(items.get(0).getIdOfCollectionsOrMaps(), R.string.array_list);
        assertEquals(items.get(1).getIdOfCollectionsOrMaps(), R.string.linked_list);
        assertEquals(items.get(2).getIdOfCollectionsOrMaps(), R.string.copy_on_write_array_list);
        assertEquals(items.get(3).getIdOfCollectionsOrMaps(), R.string.array_list);
        assertEquals(items.get(4).getIdOfCollectionsOrMaps(), R.string.linked_list);
        assertEquals(items.get(5).getIdOfCollectionsOrMaps(), R.string.copy_on_write_array_list);
        assertEquals(items.get(6).getIdOfCollectionsOrMaps(), R.string.array_list);
        assertEquals(items.get(7).getIdOfCollectionsOrMaps(), R.string.linked_list);
        assertEquals(items.get(8).getIdOfCollectionsOrMaps(), R.string.copy_on_write_array_list);
        assertEquals(items.get(9).getIdOfCollectionsOrMaps(), R.string.array_list);
        assertEquals(items.get(10).getIdOfCollectionsOrMaps(), R.string.linked_list);
        assertEquals(items.get(11).getIdOfCollectionsOrMaps(), R.string.copy_on_write_array_list);
        assertEquals(items.get(12).getIdOfCollectionsOrMaps(), R.string.array_list);
        assertEquals(items.get(13).getIdOfCollectionsOrMaps(), R.string.linked_list);
        assertEquals(items.get(14).getIdOfCollectionsOrMaps(), R.string.copy_on_write_array_list);
        assertEquals(items.get(15).getIdOfCollectionsOrMaps(), R.string.array_list);
        assertEquals(items.get(16).getIdOfCollectionsOrMaps(), R.string.linked_list);
        assertEquals(items.get(17).getIdOfCollectionsOrMaps(), R.string.copy_on_write_array_list);
        assertEquals(items.get(18).getIdOfCollectionsOrMaps(), R.string.array_list);
        assertEquals(items.get(19).getIdOfCollectionsOrMaps(), R.string.linked_list);
        assertEquals(items.get(20).getIdOfCollectionsOrMaps(), R.string.copy_on_write_array_list);

        assertEquals(items.get(0).getIdOfOperations(), R.string.adding_to_beginning);
        assertEquals(items.get(1).getIdOfOperations(), R.string.adding_to_beginning);
        assertEquals(items.get(2).getIdOfOperations(), R.string.adding_to_beginning);
        assertEquals(items.get(3).getIdOfOperations(), R.string.adding_to_middle);
        assertEquals(items.get(4).getIdOfOperations(), R.string.adding_to_middle);
        assertEquals(items.get(5).getIdOfOperations(), R.string.adding_to_middle);
        assertEquals(items.get(6).getIdOfOperations(), R.string.adding_to_end);
        assertEquals(items.get(7).getIdOfOperations(), R.string.adding_to_end);
        assertEquals(items.get(8).getIdOfOperations(), R.string.adding_to_end);
        assertEquals(items.get(9).getIdOfOperations(), R.string.search_in_list);
        assertEquals(items.get(10).getIdOfOperations(), R.string.search_in_list);
        assertEquals(items.get(11).getIdOfOperations(), R.string.search_in_list);
        assertEquals(items.get(12).getIdOfOperations(), R.string.removing_from_start);
        assertEquals(items.get(13).getIdOfOperations(), R.string.removing_from_start);
        assertEquals(items.get(14).getIdOfOperations(), R.string.removing_from_start);
        assertEquals(items.get(15).getIdOfOperations(), R.string.removing_from_middle);
        assertEquals(items.get(16).getIdOfOperations(), R.string.removing_from_middle);
        assertEquals(items.get(17).getIdOfOperations(), R.string.removing_from_middle);
        assertEquals(items.get(18).getIdOfOperations(), R.string.removing_from_end);
        assertEquals(items.get(19).getIdOfOperations(), R.string.removing_from_end);
        assertEquals(items.get(20).getIdOfOperations(), R.string.removing_from_end);
    }

    @Test
    public void getSpanCount_Three() {
        assertEquals(3, collections.getSpanCount());
    }


    @Test
    public void measureTime_IsChangeTime_False() {
        assertFalse(collections.measureTime(new BenchmarkItem(Constants.DEFAULT_TIME, R.string.array_list, R.string.adding_to_beginning), elementsCount).getTime() == Constants.DEFAULT_TIME);
    }
}