package ru.navodnikov.denis.collectionsandmaps.models;

import javax.inject.Singleton;

import dagger.Component;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.CollectionsAndMapsTestUi;

@Singleton
@Component(modules = {TestAppModule.class})
public interface TestAppComponent {
    void inject (CollectionsAndMapsTestUi test);
}
