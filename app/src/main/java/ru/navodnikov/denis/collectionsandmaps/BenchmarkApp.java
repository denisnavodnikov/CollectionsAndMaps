package ru.navodnikov.denis.collectionsandmaps;

import android.app.Application;
import android.content.Context;

public class BenchmarkApp extends Application {
    private static BenchmarkApp instance;

    public static Context getContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
