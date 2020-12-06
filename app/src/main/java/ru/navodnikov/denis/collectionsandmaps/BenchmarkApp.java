package ru.navodnikov.denis.collectionsandmaps;

import android.app.Application;
import android.content.Context;

import ru.navodnikov.denis.collectionsandmaps.models.AppComponent;
import ru.navodnikov.denis.collectionsandmaps.models.AppModule;
import ru.navodnikov.denis.collectionsandmaps.models.DaggerAppComponent;

public class BenchmarkApp extends Application {
    private static BenchmarkApp instance;
    private AppComponent appComponent;

    public static BenchmarkApp getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}
