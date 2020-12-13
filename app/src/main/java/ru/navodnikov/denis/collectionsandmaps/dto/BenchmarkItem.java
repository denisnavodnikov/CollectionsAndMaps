package ru.navodnikov.denis.collectionsandmaps.dto;


public class BenchmarkItem {
    private double time;
    private int numberOfOperations;
    private boolean progress;

    public BenchmarkItem(double time, int numberOfOperations) {
        this.time = time;
        this.numberOfOperations = numberOfOperations;
    }


    public double getTime() {
        return time;
    }

    public int getNumberOfOperations() {
        return numberOfOperations;
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


}
