package ru.navodnikov.denis.collectionsandmaps.models;

import javax.inject.Singleton;

import dagger.Component;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.BenchmarkedModelFactory;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject (BenchmarkedModelFactory benchmarkedModelFactory);
}
