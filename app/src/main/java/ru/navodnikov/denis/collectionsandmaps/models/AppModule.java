package ru.navodnikov.denis.collectionsandmaps.models;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context app;
    private final Benchmarked collections;
    private final Benchmarked maps;

    public AppModule(Context app) {
        this.app = app;
        collections = new Collections();
        maps = new Maps();
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
        return collections;
    }

    @Provides
    @Singleton
    @Named("Maps")
    public Benchmarked getMaps() {
        return maps;
    }
}
