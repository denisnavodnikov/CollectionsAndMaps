package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Matcher;
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
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class TestUIMapsFragment extends TestUIApp {


    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        BenchmarkApp app = ((BenchmarkApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext());
        app.setAppComponent(DaggerTestAppComponent.builder().testAppModule(new TestAppModule(app)).build());
    }

    @Test
    public void TestUIMapsFragment() {

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(swipeLeft());

        sleep(300);

        RecyclerViewMatcher recyclerViewMatcher_Maps = new RecyclerViewMatcher(getCurrentRecyclerView());


        testErrorEmptyFields();

        testErrorZeroFields();

        testCalculationLaunch(TestConstants.NAMES_OF_MAPS, recyclerViewMatcher_Maps);

        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click()); // TODO delete lately

        testCalculationStop(TestConstants.NAMES_OF_MAPS, recyclerViewMatcher_Maps);

//        testCalculationComplete(TestConstants.NAMES_OF_MAPS, TestConstants.MAPS_TIME, recyclerViewMatcher_Maps);


    }
}
