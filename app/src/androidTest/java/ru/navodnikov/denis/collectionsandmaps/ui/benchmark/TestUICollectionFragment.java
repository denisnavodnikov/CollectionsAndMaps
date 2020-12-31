package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.testmodels.DaggerTestAppComponent;
import ru.navodnikov.denis.collectionsandmaps.testmodels.TestAppModule;
import ru.navodnikov.denis.collectionsandmaps.ui.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class TestUICollectionFragment extends CollectionsAndMapsTestUI {

    @Rule
    public final ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        final BenchmarkApp app = ((BenchmarkApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext());
        app.setAppComponent(DaggerTestAppComponent.builder().testAppModule(new TestAppModule(app)).build());
    }

    @Test
    public void TestUICollectionsFragment() {
        testErrorEmptyFields();
        testErrorZeroFields();

        final RecyclerViewMatcher recyclerViewMatcher = new RecyclerViewMatcher(getCurrentRecyclerView());
        testCalculationLaunch(TestConstants.NAMES_OF_COLLECTIONS, recyclerViewMatcher);

        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        testCalculationStop(TestConstants.NAMES_OF_COLLECTIONS, recyclerViewMatcher);

        testCalculationComplete(TestConstants.NAMES_OF_COLLECTIONS, TestConstants.COLLECTIONS_TIME, recyclerViewMatcher);
    }
}
