package ru.navodnikov.denis.collectionsandmaps.dto;


public class BenchmarkItem {
    private double time;
    private int idOfCollectionsOrMaps;
    private int idOfOperations;
    private boolean progress;

    public BenchmarkItem(double time, int idOfCollectionsOrMaps,int idOfOperations) {
        this.time = time;
        this.idOfCollectionsOrMaps = idOfCollectionsOrMaps;
        this.idOfOperations = idOfOperations;
    }


    public double getTime() {
        return time;
    }

    public int getIdOfCollectionsOrMaps() {
        return idOfCollectionsOrMaps;
    }


    public boolean isProgress() {
        return progress;
    }


    public void setTime(double time) {
        this.time = time;
    }


    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public int getIdOfOperations() {
        return idOfOperations;
    }
}
