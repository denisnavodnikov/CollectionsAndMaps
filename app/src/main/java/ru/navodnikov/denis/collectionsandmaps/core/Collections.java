package ru.navodnikov.denis.collectionsandmaps.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Collections {
    public int contOfThreads = 5;
    public int contOfElements = 1000;

    public Collections(int contOfThreads, int contOfElements) {
        this.contOfThreads = contOfThreads;
        this.contOfElements = contOfElements;

    }

    static {
        List<Integer> arrayListAddingStart = new ArrayList<>();
        List<Integer> arrayListAddingMiddle = new ArrayList<>();
        List<Integer> arrayListAddingEnd = new ArrayList<>();
        List<Integer> arrayListSearch = new ArrayList<>();
        List<Integer> arrayListRemovingStart = new ArrayList<>();
        List<Integer> arrayListRemovingMiddle = new ArrayList<>();
        List<Integer> arrayListRemovingEnd = new ArrayList<>();

        List<Integer> linkedListAddingStart = new LinkedList<>();
        List<Integer> linkedListAddingMiddle = new LinkedList<>();
        List<Integer> linkedListAddingEnd = new LinkedList<>();
        List<Integer> linkedListSearch = new LinkedList<>();
        List<Integer> linkedListRemovingStart = new LinkedList<>();
        List<Integer> linkedListRemovingMiddle = new LinkedList<>();
        List<Integer> linkedListRemovingEnd = new LinkedList<>();

        List<Integer> CopyOnWriteArrayListAddingStart = new CopyOnWriteArrayList<>();
        List<Integer> CopyOnWriteArrayListAddingMiddle = new CopyOnWriteArrayList<>();
        List<Integer> CopyOnWriteArrayListAddingEnd = new CopyOnWriteArrayList<>();
        List<Integer> CopyOnWriteArrayListSearch = new CopyOnWriteArrayList<>();
        List<Integer> CopyOnWriteArrayListRemovingStart = new CopyOnWriteArrayList<>();
        List<Integer> CopyOnWriteArrayListRemovingMiddle = new CopyOnWriteArrayList<>();
        List<Integer> CopyOnWriteArrayListRemovingEnd = new CopyOnWriteArrayList<>();
    }

    public void arrayListAddingStart(final List<Integer> list) {
        ExecutorService threadPool = Executors.newFixedThreadPool(contOfThreads);
        for (int i = 0; i <contOfElements ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(0, 1);
                }
            });
        }

    }

}
