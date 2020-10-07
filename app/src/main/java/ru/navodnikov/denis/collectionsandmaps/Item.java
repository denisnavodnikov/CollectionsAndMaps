package ru.navodnikov.denis.collectionsandmaps;

public class Item {
    private String title;
    private String time;
//    private int id;

    public Item(String title, String time) {
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
