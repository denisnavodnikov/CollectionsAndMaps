package ru.navodnikov.denis.collectionsandmaps.dto;


public class BenchmarkItem {
    private String title;
    private String time;
    private int numberOfOperations;
    private boolean progress;

    public BenchmarkItem(String title, String time, int numberOfOperations) {
        this.title = title;
        this.time = time;
        this.numberOfOperations = numberOfOperations;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public int getNumberOfOperations() {
        return numberOfOperations;
    }

    public void setNumberOfOperations(int numberOfOperations) {
        this.numberOfOperations = numberOfOperations;
    }

    public boolean isProgress() {
        return progress;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public void setProgress(boolean progress) {
        this.progress = progress;
    }


}
