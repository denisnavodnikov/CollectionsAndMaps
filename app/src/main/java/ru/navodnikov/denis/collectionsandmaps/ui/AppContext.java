package ru.navodnikov.denis.collectionsandmaps.ui;

import android.app.Application;
import android.content.Context;

public class AppContext extends Application {
    private static AppContext instance;

    public static Context getContext() {
        return instance.getApplicationContext();
    }
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }

}
