package ru.navodnikov.denis.collectionsandmaps;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.TestSwipeActivity;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.TestUICollectionFragment;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.TestUIMapsFragment;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSwipeActivity.class,
        TestUICollectionFragment.class,
        TestUIMapsFragment.class
})
public class TestSuiteUI {
}
