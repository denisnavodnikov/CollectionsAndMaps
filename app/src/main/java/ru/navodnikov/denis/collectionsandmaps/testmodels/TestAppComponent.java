package ru.navodnikov.denis.collectionsandmaps.testmodels;

import javax.inject.Singleton;

import dagger.Component;
import ru.navodnikov.denis.collectionsandmaps.models.AppComponent;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.BenchmarkedModelFactory;

@Singleton
@Component(modules = {TestAppModule.class})
public interface TestAppComponent extends AppComponent {
    void inject (BenchmarkedModelFactory benchmarkedModelFactory);
}
