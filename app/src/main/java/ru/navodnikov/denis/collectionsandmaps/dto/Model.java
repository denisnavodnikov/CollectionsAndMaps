package ru.navodnikov.denis.collectionsandmaps.dto;

public class Model {
    private String title;
    private String time;

    public Model(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

}
