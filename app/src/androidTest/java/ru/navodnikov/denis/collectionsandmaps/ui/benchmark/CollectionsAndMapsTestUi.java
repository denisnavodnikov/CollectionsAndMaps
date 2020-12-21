package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.models.TestAppComponent;
import ru.navodnikov.denis.collectionsandmaps.ui.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class CollectionsAndMapsTestUi {

    @Inject
    BenchmarkApp benchmarkApp;


    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);
    TestAppComponent testAppComponent = DaggerTestAppComponent.builder().appModule(TestAppModule(BenchmarkApp.instance)).build();
    testAppComponent.inject(this);


    @Test
    public void measureTime_happyTest() {

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText("10000"));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText("6"));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        TODO
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

    }

    @Test
    public void measureTime_elementsIsEmpty() {

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(""));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText("6"));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        TODO
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

    }

    @Test
    public void measureTime_threadsIsEmpty() {

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText("10000"));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(""));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        TODO
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

    }

    @Test
    public void measureTime_elementsIsZero() {

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText("0"));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText("6"));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        TODO
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

    }

    @Test
    public void measureTime_threadsIsZero() {

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText("10000"));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText("0"));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        TODO
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());

    }

}