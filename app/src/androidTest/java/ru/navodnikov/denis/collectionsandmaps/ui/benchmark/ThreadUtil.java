package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

public class ThreadUtil {

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
