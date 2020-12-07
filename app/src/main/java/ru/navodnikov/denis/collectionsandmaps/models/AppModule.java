package ru.navodnikov.denis.collectionsandmaps.models;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context app;

    public AppModule(Context app) {
        this.app = app;

    }

    @Provides
    @Singleton
    public Context getApp() {
        return app;
    }

    @Provides
    @Singleton
    @Named("Collections")
    public Benchmarked getCollections() {
        return new Collections();
    }

    @Provides
    @Singleton
    @Named("Maps")
    public Benchmarked getMaps() {
        return new Maps();
    }
}
