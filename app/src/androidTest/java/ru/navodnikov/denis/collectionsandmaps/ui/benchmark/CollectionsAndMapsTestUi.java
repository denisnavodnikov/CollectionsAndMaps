package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.testmodels.DaggerTestAppComponent;
import ru.navodnikov.denis.collectionsandmaps.testmodels.TestAppModule;
import ru.navodnikov.denis.collectionsandmaps.ui.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withAlpha;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class CollectionsAndMapsTestUi {
    private RecyclerViewMatcher recyclerViewMatcher_Collections;
    private RecyclerViewMatcher recyclerViewMatcher_Maps;
    private Matcher recyclerViewMatcher = allOf(withId(R.id.recycler_view), isDisplayed());

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        BenchmarkApp app = ((BenchmarkApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext());
        app.setAppComponent(DaggerTestAppComponent.builder().testAppModule(new TestAppModule(app)).build());
    }


    @Test
    public void TestUiFragment() {


        testInitialState();

        testErrorEmptyFields();

        testErrorZeroFields();

        testCalculationLaunch(TestConstants.NAMES_OF_COLLECTIONS, recyclerViewMatcher_Collections);

        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click()); // TODO delete lately

        testCalculationStop(TestConstants.NAMES_OF_COLLECTIONS, recyclerViewMatcher_Collections);

//        testCalculationComplete(TestConstants.NAMES_OF_COLLECTIONS, TestConstants.COLLECTIONS_TIME, recyclerViewMatcher_Collections);

        onView(recyclerViewMatcher)
                .perform(swipeLeft());

        testErrorEmptyFields();

        testErrorZeroFields();

        testCalculationLaunch(TestConstants.NAMES_OF_MAPS, recyclerViewMatcher_Maps);

        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click()); // TODO delete lately

        testCalculationStop(TestConstants.NAMES_OF_MAPS, recyclerViewMatcher_Maps);

//        testCalculationComplete(TestConstants.NAMES_OF_MAPS, TestConstants.MAPS_TIME, recyclerViewMatcher_Maps);


    }


    public void testInitialState() {

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
            if (!itemIsDisplayed(i)) {
                onView(recyclerViewMatcher)
                        .perform(actionOnItemAtPosition(i, scrollTo()));
                sleep(300);
            }
            checkRecyclerViewItem(recyclerViewMatcher_Collections, TestConstants.NAMES_OF_COLLECTIONS, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_0);
        }
        onView(recyclerViewMatcher)
                .perform(RecyclerViewActions.scrollToPosition(0));
    }

    public void testErrorEmptyFields() {
        sleep(300);
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.EMPTY));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.EMPTY));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).check(matches(hasErrorText(TestConstants.ELEMENTS_EMPTY)));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).check(matches(hasErrorText(TestConstants.THREADS_EMPTY)));


    }

    public void testErrorZeroFields() {
        sleep(300);
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.ZERO));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.ZERO));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).check(matches(hasErrorText(TestConstants.ELEMENTS_ZERO)));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).check(matches(hasErrorText(TestConstants.THREADS_ZERO)));

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());
    }

    public void testCalculationLaunch(String[] names, RecyclerViewMatcher recyclerViewMatcher) {
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.TEST_ELEMENTS));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.TEST_THREADS));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        for (int i = 0; i < names.length; i++) {
            if (names==TestConstants.NAMES_OF_COLLECTIONS && itemIsDisplayed(i)) {
                onView(this.recyclerViewMatcher)
                        .perform(actionOnItemAtPosition(i, scrollTo()));
                sleep(1000);
            }
            checkRecyclerViewItem(recyclerViewMatcher, names, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_1);
        }
        onView(this.recyclerViewMatcher)
                .perform(RecyclerViewActions.scrollToPosition(0));

        sleep(2000);

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

    }

    public void testCalculationStop(String[] names, RecyclerViewMatcher recyclerViewMatcher) {
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.TEST_ELEMENTS));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.TEST_THREADS));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        sleep(300);
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        sleep(300);

        for (int i = 0; i < names.length; i++) {
            if (names==TestConstants.NAMES_OF_COLLECTIONS && itemIsDisplayed(i)) {
                onView(this.recyclerViewMatcher)
                        .perform(actionOnItemAtPosition(i, scrollTo()));
                sleep(300);
            }
            checkRecyclerViewItem(recyclerViewMatcher, names, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_0);
        }

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());
    }

    public void testCalculationComplete(String[] names, String time, RecyclerViewMatcher recyclerViewMatcher) {
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.TEST_ELEMENTS));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.TEST_THREADS));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        sleep(6000);

        for (int i = 0; i < names.length; i++) {
            if (itemIsDisplayed(i)) {
                onView(this.recyclerViewMatcher)
                        .perform(actionOnItemAtPosition(i, scrollTo()));
                sleep(300);
            }
            checkRecyclerViewItem(recyclerViewMatcher, names, i, time, TestConstants.ALPHA_0);
        }
        onView(this.recyclerViewMatcher)
                .perform(RecyclerViewActions.scrollToPosition(0));
    }


    public boolean itemIsDisplayed(int position) {
        try {
            onView(recyclerViewMatcher_Collections.atPosition(position)).check(matches(isDisplayed()));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void checkRecyclerViewItem(RecyclerViewMatcher matcher, String[] names, int position, String time, float alpha) {
        onView(matcher.atPositionOnView(position, R.id.name_of_operation))
                .check(matches(withText(names[position])));
        onView(matcher.atPositionOnView(position, R.id.time_of_operation))
                .check(matches(withText(time)));
        onView(matcher.atPositionOnView(position, R.id.progressBar))
                .check(matches(withAlpha(alpha)));

    }


    public RecyclerView getCurrentRecyclerView() {
        final View[] rv = new View[1];
        onView(recyclerViewMatcher)
                .perform(new ViewAction() {
                    @Override
                    public Matcher<View> getConstraints() {
                        return isAssignableFrom(RecyclerView.class);
                    }

                    @Override
                    public String getDescription() {
                        return "";
                    }

                    @Override
                    public void perform(UiController uiController, View view) {
                        rv[0] = view;
                    }
                });
        return (RecyclerView) rv[0];
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}