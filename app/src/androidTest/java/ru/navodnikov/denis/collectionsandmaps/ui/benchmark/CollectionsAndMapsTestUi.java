package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.ui.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withAlpha;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class CollectionsAndMapsTestUi {


    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        ((BenchmarkApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext()).setAppComponent();
    }


    @Test
    public void measureTime_CollectionsFragment() {

        String[] names = {
                "Adding to start in ArrayList",
                "Adding to start in LinkedList",
                "Adding to start in CopyOnWriteArrayList",
                "Adding to middle in ArrayList",
                "Adding to middle in LinkedList",
                "Adding to middle in CopyOnWriteArrayList",
                "Adding to end in ArrayList",
                "Adding to end in LinkedList",
                "Adding to end in CopyOnWriteArrayList",
                "Search in ArrayList",
                "Search in LinkedList",
                "Search in CopyOnWriteArrayList",
                "Removing from start in ArrayList",
                "Removing from start in LinkedList",
                "Removing from start in CopyOnWriteArrayList",
                "Removing from middle in ArrayList",
                "Removing from middle in LinkedList",
                "Removing from middle in CopyOnWriteArrayList",
                "Removing from end in ArrayList",
                "Removing from end in LinkedList",
                "Removing from end in CopyOnWriteArrayList"};

//testing start
        for (int i = 0; i < 9; i++) {

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(15));
        for (int i = 9; i < 18; i++) {

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(names.length - 1));

        for (int i = 18; i < names.length; i++) {

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));

//testing empty fields
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(""));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(""));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).check(matches(hasErrorText("Amount of elements must not be empty")));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).check(matches(hasErrorText("Amount of threads must not be empty")));

//testing zero fields

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText("0"));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText("0"));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).check(matches(hasErrorText("Amount of elements must not be zero")));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).check(matches(hasErrorText("Amount of threads must not be zero")));

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

//testing valid parameters

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText("10000"));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText("6"));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        for (int i = 0; i < 9; i++) {

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
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

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
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

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
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

//        for (int i = 0; i < 9; i++) {
//
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.name_of_operation))
//                    .check(matches(withText(names[i])));
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.time_of_operation))
//                    .check(matches(withText("3.00000 ms")));
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.progressBar))
//                    .check(matches(withAlpha(0)));
//        }
//        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
//                .perform(RecyclerViewActions.scrollToPosition(15));
//        for (int i = 9; i < 18; i++) {
//
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.name_of_operation))
//                    .check(matches(withText(names[i])));
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.time_of_operation))
//                    .check(matches(withText("3.00000 ms")));
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.progressBar))
//                    .check(matches(withAlpha(0)));
//        }
//
//        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
//                .perform(RecyclerViewActions.scrollToPosition(names.length - 1));
//
//        for (int i = 18; i < names.length; i++) {
//
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.name_of_operation))
//                    .check(matches(withText(names[i])));
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.time_of_operation))
//                    .check(matches(withText("3.00000 ms")));
//            onView(new RecyclerViewMatcher(R.id.recycler_view)
//                    .atPositionOnView(i, R.id.progressBar))
//                    .check(matches(withAlpha(0)));
//        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));


        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

// testing interruption of calculation

        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click()); // TODO delete lately

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText("10000"));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText("6"));
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

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(15));
        for (int i = 9; i < 18; i++) {

            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(names.length - 1));

        for (int i = 18; i < names.length; i++) {


            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.name_of_operation))
                    .check(matches(withText(names[i])));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.time_of_operation))
                    .check(matches(withText("N/A ms")));
            onView(new RecyclerViewMatcher(R.id.recycler_view)
                    .atPositionOnView(i, R.id.progressBar))
                    .check(matches(withAlpha(0)));
        }

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));
    }

    @Test
    public void measureTime_MapsFragment() {


    }


}