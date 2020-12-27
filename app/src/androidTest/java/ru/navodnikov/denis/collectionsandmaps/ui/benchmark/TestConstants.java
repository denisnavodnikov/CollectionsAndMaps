package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

public class TestConstants {
    public static final String DEFAULT_TIME = "N/A ms";
    public static final String COLLECTIONS_TIME = "3.00000 ms";
    public static final String MAPS_TIME = "2.00000 ms";
    public static final String[] NAMES_OF_COLLECTIONS = {
            "Adding to start in ArrayList",
            "Adding to start in LinkedList",
            "Adding to start in CopyOnWriteArrayList",
            "Adding to middle in ArrayList",
            "Adding to middle in LinkedList",
            "Adding to middle in CopyOnWriteArrayList",
            "Adding to end in ArrayList",
            "Adding to end in LinkedList",
            "Adding to end in CopyOnWriteArrayList",
            "Search in ArrayList",
            "Search in LinkedList",
            "Search in CopyOnWriteArrayList",
            "Removing from start in ArrayList",
            "Removing from start in LinkedList",
            "Removing from start in CopyOnWriteArrayList",
            "Removing from middle in ArrayList",
            "Removing from middle in LinkedList",
            "Removing from middle in CopyOnWriteArrayList",
            "Removing from end in ArrayList",
            "Removing from end in LinkedList",
            "Removing from end in CopyOnWriteArrayList"
    };

    public static final String[] NAMES_OF_MAPS = {
            "Adding to HashMap",
            "Adding to TreeMap",
            "Search in HashMap",
            "Search in TreeMap",
            "Removing from HashMap",
            "Removing from TreeMap"
    };
    public static final String ELEMENTS_EMPTY = "Amount of elements must not be empty";
    public static final String THREADS_EMPTY = "Amount of threads must not be empty";
    public static final String ELEMENTS_ZERO = "Amount of elements must not be zero";
    public static final String THREADS_ZERO = "Amount of threads must not be zero";
    public static final String ZERO = "0";
    public static final String EMPTY = "";
    public static final String TEST_ELEMENTS = "10000";
    public static final String TEST_THREADS = "6";
    public static final float ALPHA_1 = 1;
    public static final float ALPHA_0 = 0;
}
