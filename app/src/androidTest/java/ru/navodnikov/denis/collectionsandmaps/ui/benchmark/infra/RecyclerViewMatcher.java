package ru.navodnikov.denis.collectionsandmaps.ui.benchmark.infra;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.hamcrest.Matcher;

public class RecyclerViewMatcher {
    private final RecyclerView recyclerView;

    public RecyclerViewMatcher(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public Matcher<View> atPosition(final int position) {
        return atPositionOnView(position, -1);
    }

    public Matcher<View> atPositionOnView(final int position, final int targetViewId) {

        return new TestTypeSafeMatcher(position, recyclerView, targetViewId);
    }
}
