package ru.navodnikov.denis.collectionsandmaps.testmodels;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.navodnikov.denis.collectionsandmaps.models.Benchmarked;

@Module
public class TestAppModule {
    private final Context app;

    public TestAppModule(Context app) {
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
        return new TestCollections();
    }

    @Provides
    @Singleton
    @Named("Maps")
    public Benchmarked getMaps() {
        return new TestMaps();
    }
}
