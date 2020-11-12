package ru.navodnikov.denis.collectionsandmaps.dto;

import android.widget.ProgressBar;

public class BenchmarkItem {
    private String title;
    private String time;
    private boolean progress;

    public BenchmarkItem(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
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
