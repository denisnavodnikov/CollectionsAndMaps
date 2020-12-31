package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.viewpager.widget.ViewPager;

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
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertEquals;
import static ru.navodnikov.denis.collectionsandmaps.ui.benchmark.CollectionsAndMapsTestUI.sleep;

public class TestSwipeActivity {

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        BenchmarkApp app = ((BenchmarkApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext());
        app.setAppComponent(DaggerTestAppComponent.builder().testAppModule(new TestAppModule(app)).build());
    }

    @Test
    public void testInitialState() {

        final ViewPager[] viewPager = new ViewPager[1];
        int positionOfCollections = 0;
        int positionOfMaps = 1;
        activity.getScenario().onActivity(activity1 ->  viewPager[0] = activity1.findViewById(R.id.view_pager));

        Matcher recyclerViewMatcher = allOf(withId(R.id.recycler_view), isDisplayed());

        assertEquals("Selected page", positionOfCollections, viewPager[0].getCurrentItem());

        sleep(300);

        onView(recyclerViewMatcher)
                .perform(swipeLeft());

        sleep(300);

        assertEquals("Selected page", positionOfMaps, viewPager[0].getCurrentItem());
        onView(recyclerViewMatcher)
                .perform(swipeRight());

        sleep(300);
        assertEquals("Selected page", positionOfCollections, viewPager[0].getCurrentItem());

        onView(withText(TestConstants.NAME_TAB_MAPS)).perform(click());

        sleep(300);
        assertEquals("Selected page", positionOfMaps, viewPager[0].getCurrentItem());

        sleep(300);

        onView(withText(TestConstants.NAME_TAB_COLLECTIONS)).perform(click());

        sleep(300);

        assertEquals("Selected page", 0, viewPager[0].getCurrentItem());


    }
}
