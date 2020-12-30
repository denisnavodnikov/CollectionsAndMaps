package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import androidx.test.espresso.contrib.RecyclerViewActions;
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
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static ru.navodnikov.denis.collectionsandmaps.ui.benchmark.TestUIApp.sleep;

public class TestSwipeActivity extends TestUIApp {

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        BenchmarkApp app = ((BenchmarkApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext());
        app.setAppComponent(DaggerTestAppComponent.builder().testAppModule(new TestAppModule(app)).build());
    }

    @Test
    public void testInitialState() {
        RecyclerViewMatcher recyclerViewMatcher_Collections;
        RecyclerViewMatcher recyclerViewMatcher_Maps;
        Matcher recyclerViewMatcher = allOf(withId(R.id.recycler_view), isDisplayed());


        sleep(300);
        recyclerViewMatcher_Collections = new RecyclerViewMatcher(getCurrentRecyclerView());

        onView(recyclerViewMatcher)
                .perform(swipeLeft());

        sleep(300);
        recyclerViewMatcher_Maps = new RecyclerViewMatcher(getCurrentRecyclerView());

        onView(recyclerViewMatcher)
                .perform(swipeRight());

        sleep(300);

        onView(withText(TestConstants.NAME_TAB_MAPS)).perform(click());

        sleep(300);

        for (int i = 0; i < TestConstants.NAMES_OF_MAPS.length; i++) {

            checkRecyclerViewItem(recyclerViewMatcher_Maps, TestConstants.NAMES_OF_MAPS, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_0);
        }

        onView(withText(TestConstants.NAME_TAB_COLLECTIONS)).perform(click());

        sleep(300);

        for (int i = 0; i < TestConstants.NAMES_OF_COLLECTIONS.length; i++) {
            if (itemIsDisplayed(i)) {
                onView(recyclerViewMatcher)
                        .perform(actionOnItemAtPosition(i, scrollTo()));
                sleep(300);
            }
            checkRecyclerViewItem(recyclerViewMatcher_Collections, TestConstants.NAMES_OF_COLLECTIONS, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_0);
        }
        onView(recyclerViewMatcher)
                .perform(RecyclerViewActions.scrollToPosition(0));
    }
}
