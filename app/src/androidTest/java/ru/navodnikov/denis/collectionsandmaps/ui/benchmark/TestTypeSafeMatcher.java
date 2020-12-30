package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.content.res.Resources;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;


public class TestTypeSafeMatcher extends TypeSafeMatcher<View> {
    private Resources resources = null;
    private View childView;
    private final int position;
    private final RecyclerView recyclerView;
    private final int targetViewId;

    public TestTypeSafeMatcher(int position, RecyclerView recyclerView, int targetViewId) {
        this.position = position;
        this.recyclerView = recyclerView;
        this.targetViewId = targetViewId;
    }

    @Override
    public void describeTo(Description description) {
        String idDescription = Integer.toString(recyclerView.getId());
        if (this.resources != null) {
            try {
                idDescription = this.resources.getResourceName(recyclerView.getId());
            } catch (Resources.NotFoundException var4) {
                idDescription = String.format("%s (resource name not found)", recyclerView.getId());
            }
        }

        description.appendText("with id: " + idDescription);
    }

    @Override
    public boolean matchesSafely(View view) {

        this.resources = view.getResources();

        if (childView == null) {
            if (recyclerView != null) {
                childView = recyclerView.findViewHolderForAdapterPosition(position).itemView;
            } else {
                return false;
            }
        }

        if (targetViewId == -1) {
            return view == childView;
        } else {
            View targetView = childView.findViewById(targetViewId);
            return view == targetView;
        }
    }



}
