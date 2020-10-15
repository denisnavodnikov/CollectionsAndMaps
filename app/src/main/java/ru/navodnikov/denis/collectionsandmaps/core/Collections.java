package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.CollectionsFragment;

public class Collections {
    public int contOfElements;
    public int contOfThreads;


    public Collections(int contOfElements, int contOfThreads) {
        this.contOfElements = contOfElements;
        this.contOfThreads = contOfThreads;
    }


    static List<Integer> arrayListAddingStart = new ArrayList<>();
    static List<Integer> arrayListAddingMiddle = new ArrayList<>();
    static List<Integer> arrayListAddingEnd = new ArrayList<>();
    static List<Integer> arrayListSearch = new ArrayList<>();
    static List<Integer> arrayListRemovingStart = new ArrayList<>();
    static List<Integer> arrayListRemovingMiddle = new ArrayList<>();
    static List<Integer> arrayListRemovingEnd = new ArrayList<>();

    static List<Integer> linkedListAddingStart = new LinkedList<>();
    static List<Integer> linkedListAddingMiddle = new LinkedList<>();
    static List<Integer> linkedListAddingEnd = new LinkedList<>();
    static List<Integer> linkedListSearch = new LinkedList<>();
    static List<Integer> linkedListRemovingStart = new LinkedList<>();
    static List<Integer> linkedListRemovingMiddle = new LinkedList<>();
    static List<Integer> linkedListRemovingEnd = new LinkedList<>();

    static List<Integer> CopyOnWriteArrayListAddingStart = new CopyOnWriteArrayList<>();
    static List<Integer> CopyOnWriteArrayListAddingMiddle = new CopyOnWriteArrayList<>();
    static List<Integer> CopyOnWriteArrayListAddingEnd = new CopyOnWriteArrayList<>();
    static List<Integer> CopyOnWriteArrayListSearch = new CopyOnWriteArrayList<>();
    static List<Integer> CopyOnWriteArrayListRemovingStart = new CopyOnWriteArrayList<>();
    static List<Integer> CopyOnWriteArrayListRemovingMiddle = new CopyOnWriteArrayList<>();
    static List<Integer> CopyOnWriteArrayListRemovingEnd = new CopyOnWriteArrayList<>();


    public void collectionOperations() {

        ExecutorService threadPool = Executors.newFixedThreadPool(contOfThreads);

        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListAddingStart.add(0, 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(0).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListAddingStart.add(0, 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(1).setTime((((double) (endTime - startTime) / 1000000) + " ms"));

        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListAddingStart.add(0, 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(2).setTime((((double) (endTime - startTime) / 1000000) + " ms"));

        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListAddingMiddle.add(arrayListAddingMiddle.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(3).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListAddingMiddle.add(linkedListAddingMiddle.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(4).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListAddingMiddle.add(CopyOnWriteArrayListAddingMiddle.size() / 2, 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(5).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListAddingEnd.add(1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(6).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListAddingEnd.add(1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(7).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListAddingEnd.add(1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(8).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });


        threadPool.execute(() -> {
            arrayListSearch.add(1);
            arrayListSearch.add(2);
            arrayListSearch.add(3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListSearch.contains(2);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(9).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            linkedListSearch.add(1);
            linkedListSearch.add(2);
            linkedListSearch.add(3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListSearch.contains(2);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(10).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });

        threadPool.execute(() -> {
            CopyOnWriteArrayListSearch.add(1);
            CopyOnWriteArrayListSearch.add(2);
            CopyOnWriteArrayListSearch.add(3);
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListSearch.contains(2);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(11).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });


        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingStart.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingStart.remove(0);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(12).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingStart.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingStart.remove(0);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(13).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingStart.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingStart.remove(0);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(14).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });


        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingMiddle.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingMiddle.remove(arrayListRemovingMiddle.size() / 2);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(15).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingMiddle.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingMiddle.remove(linkedListRemovingMiddle.size() / 2);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(16).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingMiddle.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingMiddle.remove(CopyOnWriteArrayListRemovingMiddle.size() / 2);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(17).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });


        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingEnd.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                arrayListRemovingEnd.remove(arrayListRemovingEnd.size() - 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(18).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingEnd.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                linkedListRemovingEnd.remove(linkedListRemovingEnd.size() - 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(19).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });
        threadPool.execute(() -> {
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingEnd.add(1);
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < contOfElements; i++) {
                CopyOnWriteArrayListRemovingEnd.remove(CopyOnWriteArrayListRemovingEnd.size() - 1);
            }
            long endTime = System.nanoTime();
            CollectionsFragment.listOfCollections.get(20).setTime((((double) (endTime - startTime) / 1000000) + " ms"));
        });


        threadPool.shutdown();
        try {
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
