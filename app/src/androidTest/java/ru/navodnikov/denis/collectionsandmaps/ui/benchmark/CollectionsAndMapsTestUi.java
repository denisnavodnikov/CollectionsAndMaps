package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.models.AppComponent;
import ru.navodnikov.denis.collectionsandmaps.testmodels.DaggerTestAppComponent;
import ru.navodnikov.denis.collectionsandmaps.testmodels.TestAppModule;
import ru.navodnikov.denis.collectionsandmaps.ui.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withAlpha;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class CollectionsAndMapsTestUi {
    private RecyclerViewMatcher recyclerViewMatcher;
    private RecyclerView recyclerView;

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
        AppComponent appComponent = DaggerTestAppComponent.builder().testAppModule(new TestAppModule(context)).build();
        ((BenchmarkApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext()).setAppComponent(appComponent);
    }


    @Test
    public void measureTime_CollectionsFragment() {

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recyclerView = getCurrentRecyclerView();
        recyclerViewMatcher = new RecyclerViewMatcher(recyclerView);
        testInitialState();
//        testErrorEmptyFilds();
//        testErrorZeroFilds();
//        testCalculationLaunch();
//        testCalculationStop();
//        testCalculationComplete();

//testing start
        /*
        for (int i = 0; i < 9; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(15));
        for (int i = 9; i < 18; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(names.length - 1));

        for (int i = 18; i < names.length; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));

//testing empty fields
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.EMPTY));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.EMPTY));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).check(matches(hasErrorText(TestConstants.ELEMENTS_EMPTY)));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).check(matches(hasErrorText(TestConstants.THREADS_EMPTY)));

//testing zero fields

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.ZERO));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.ZERO));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).check(matches(hasErrorText(TestConstants.ELEMENTS_ZERO)));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).check(matches(hasErrorText(TestConstants.THREADS_ZERO)));

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

//testing valid parameters

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.TEST_ELEMENTS));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.TEST_THREADS));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        for (int i = 0; i < 9; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(1)));
        }
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(15));

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 9; i < 18; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(1)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(names.length - 1));

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 18; i < names.length; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(1)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//testing results

        for (int i = 0; i < 9; i++) {

            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("3.00000 ms")));
            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(15));
        for (int i = 9; i < 18; i++) {

            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("3.00000 ms")));
            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(names.length - 1));

        for (int i = 18; i < names.length; i++) {

            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("3.00000 ms")));
            onView(recyclerViewMatcher
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));


        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

// testing interruption of calculation

        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click()); // TODO delete lately

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.TEST_ELEMENTS));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.TEST_THREADS));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 9; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(15));
        for (int i = 9; i < 18; i++) {

            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(names.length - 1));

        for (int i = 18; i < names.length; i++) {


            onView(recyclerViewMatcher.atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(recyclerViewMatcher.atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));

         */
    }

    private void testInitialState() {
        for (int i = 0; i < TestConstants.NAMES_OF_COLLECTIONS.length; i++) {
            if (!itemIsDisplayed(i)) {
                onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                        .perform(actionOnItemAtPosition(i, scrollTo()));
            }
            checkText(recyclerViewMatcher, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_0);
        }
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));
    }


    private boolean itemIsDisplayed(int position) {
        try {
            onView(recyclerViewMatcher.atPosition(position)).check(matches(isCompletelyDisplayed()));
            return true;
        } catch (AssertionFailedError e) {
            return false;
        }
    }

    protected void checkText(RecyclerViewMatcher matcher, int position, String time, float alpha) {
        onView(matcher.atPositionOnView(position, R.id.name_of_operation))
                .check(matches(withText(TestConstants.NAMES_OF_COLLECTIONS[position])));
        onView(matcher.atPositionOnView(position, R.id.time_of_operation))
                .check(matches(withText(time)));
        onView(matcher.atPositionOnView(position, R.id.progressBar))
                .check(matches(withAlpha(alpha)));

    }


    public RecyclerView getCurrentRecyclerView() {
        final View[] rv = new View[1];
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
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


}