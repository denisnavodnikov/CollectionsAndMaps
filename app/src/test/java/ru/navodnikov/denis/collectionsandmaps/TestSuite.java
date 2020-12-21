package ru.navodnikov.denis.collectionsandmaps;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ru.navodnikov.denis.collectionsandmaps.models.CollectionsTest;
import ru.navodnikov.denis.collectionsandmaps.models.MapsTest;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.BenchmarkedViewModelTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CollectionsTest.class,
        MapsTest.class,
        BenchmarkedViewModelTest.class
})
public class TestSuite {
}
