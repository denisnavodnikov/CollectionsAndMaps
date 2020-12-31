package ru.navodnikov.denis.collectionsandmaps.ui.benchmark.infra;

public class ThreadUtil {

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
