package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.infra.RecyclerViewMatcher;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.infra.TestConstants;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.infra.ThreadUtil;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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

public class CollectionsAndMapsTestUI {
    private final Matcher<View> matcher = allOf(withId(R.id.recycler_view), isDisplayed());


    public void testErrorEmptyFields() {
        ThreadUtil.sleep(300);
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.EMPTY));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.EMPTY));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).check(matches(hasErrorText(TestConstants.ELEMENTS_EMPTY)));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).check(matches(hasErrorText(TestConstants.THREADS_EMPTY)));
    }

    public void testErrorZeroFields() {
        ThreadUtil.sleep(300);
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
            if (names == TestConstants.NAMES_OF_COLLECTIONS && itemIsNotDisplayed(i)) {
                onView(matcher).perform(actionOnItemAtPosition(i, scrollTo()));
                ThreadUtil.sleep(1000);
            }
            checkRecyclerViewItem(recyclerViewMatcher, names, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_1);
        }
        onView(matcher).perform(RecyclerViewActions.scrollToPosition(0));

        ThreadUtil.sleep(2000);

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());
    }

    public void testCalculationStop(String[] names, RecyclerViewMatcher recyclerViewMatcher) {
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.TEST_ELEMENTS));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.TEST_THREADS));
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        ThreadUtil.sleep(300);
        onView(allOf(withId(R.id.start_button), isDisplayed())).perform(click());
        ThreadUtil.sleep(300);

        for (int i = 0; i < names.length; i++) {
            if (names == TestConstants.NAMES_OF_COLLECTIONS && itemIsNotDisplayed(i)) {
                onView(matcher).perform(actionOnItemAtPosition(i, scrollTo()));
                ThreadUtil.sleep(300);
            }
            checkRecyclerViewItem(recyclerViewMatcher, names, i, TestConstants.DEFAULT_TIME, TestConstants.ALPHA_0);
        }

        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(clearText());
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(clearText());
    }

    public void testCalculationComplete(String[] names, String time, RecyclerViewMatcher recyclerViewMatcher) {
        onView(allOf(withId(R.id.edit_text_elements), isDisplayed())).perform(typeText(TestConstants.TEST_ELEMENTS));
        onView(allOf(withId(R.id.edit_text_threads), isDisplayed())).perform(typeText(TestConstants.TEST_THREADS));

        final ViewInteraction buttonInteraction = onView(allOf(withId(R.id.start_button), isDisplayed()));
        buttonInteraction.perform(click());

        boolean wait = true;
        while (wait) {
            ThreadUtil.sleep(1000);
            try {
                buttonInteraction.check(ViewAssertions.matches(ViewMatchers.isChecked()));
            } catch (Throwable ignore) {
                wait = false;
            }
        }

        for (int i = 0; i < names.length; i++) {
            if (names == TestConstants.NAMES_OF_COLLECTIONS && itemIsNotDisplayed(i)) {
                onView(matcher).perform(actionOnItemAtPosition(i, scrollTo()));
                ThreadUtil.sleep(300);
            }
            checkRecyclerViewItem(recyclerViewMatcher, names, i, time, TestConstants.ALPHA_0);
        }
        onView(matcher).perform(RecyclerViewActions.scrollToPosition(0));
    }


    public boolean itemIsNotDisplayed(int position) {
        try {
            onView(new RecyclerViewMatcher(getCurrentRecyclerView()).atPosition(position)).check(matches(isDisplayed()));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void checkRecyclerViewItem(RecyclerViewMatcher matcher, String[] names, int position,
                                      String time, float alpha) {
        onView(matcher.atPositionOnView(position, R.id.name_of_operation))
                .check(matches(withText(names[position])));

        onView(matcher.atPositionOnView(position, R.id.time_of_operation))
                .check(matches(withText(time)));

        onView(matcher.atPositionOnView(position, R.id.progressBar))
                .check(matches(withAlpha(alpha)));
    }


    public RecyclerView getCurrentRecyclerView() {
        final View[] rv = new View[1];
        onView(matcher)
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
