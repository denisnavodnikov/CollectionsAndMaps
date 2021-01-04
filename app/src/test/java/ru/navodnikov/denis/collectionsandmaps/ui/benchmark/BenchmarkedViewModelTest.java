package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.models.Maps;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class BenchmarkedViewModelTest {

    @Rule
    public final RxImmediateSchedulerRule schedulers = new RxImmediateSchedulerRule();

    private BenchmarkedViewModel viewModel;
    private BenchmarkFragment callbackFragment;
    private String threadsCount;
    private String elementsCount;
    private boolean isChecked = true;

    @Before
    public void setUp() {
        callbackFragment = mock(BenchmarkFragment.class);
        viewModel = new BenchmarkedViewModel(new Maps());
        viewModel.registerCallback(callbackFragment);
    }

    @Test
    public void onButtonClicked_ElementsCount_Null() {
        threadsCount = "3";
        elementsCount = null;

        viewModel.onButtonClicked(elementsCount, threadsCount, isChecked);

        verify(callbackFragment).setErrorToElements(R.string.elements_empty);
        verify(callbackFragment).setCheckedButton(false);
        verifyNoMoreInteractions(callbackFragment);
    }

    @Test
    public void onButtonClicked_ThreadsCount_Null() {
        threadsCount = null;
        elementsCount = "100000";

        viewModel.onButtonClicked(elementsCount, threadsCount, isChecked);

        verify(callbackFragment).setErrorToThreads(R.string.threads_empty);
        verify(callbackFragment).setCheckedButton(false);
        verifyNoMoreInteractions(callbackFragment);
    }

    @Test
    public void onButtonClicked_ElementsCount_Zero() {
        threadsCount = "3";
        elementsCount = "0";

        viewModel.onButtonClicked(elementsCount, threadsCount, isChecked);

        verify(callbackFragment).setErrorToElements(R.string.elements_zero);
        verify(callbackFragment).setCheckedButton(false);
        verifyNoMoreInteractions(callbackFragment);
    }

    @Test
    public void onButtonClicked_ThreadsCount_Zero() {
        threadsCount = "0";
        elementsCount = "100000";

        viewModel.onButtonClicked(elementsCount, threadsCount, isChecked);

        verify(callbackFragment).setErrorToThreads(R.string.threads_zero);
        verify(callbackFragment).setCheckedButton(false);
        verifyNoMoreInteractions(callbackFragment);
    }

    @Test
    public void onButtonClicked_MeasureTime() {
        threadsCount = "3";
        elementsCount = "100000";

        viewModel.onButtonClicked(elementsCount, threadsCount, isChecked);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        verify(callbackFragment, times(1)).setProgress(true);
        verify(callbackFragment, times(1)).setProgress(false);
        verify(callbackFragment, times(1)).showMessage(R.string.calculation_is_finished);
        verify(callbackFragment, times(6)).updateItemInAdaptor(any(BenchmarkItem.class));
        verify(callbackFragment, times(1)).setCheckedButton(false);
        verify(callbackFragment, times(1)).hideKeyboard();
        verifyNoMoreInteractions(callbackFragment);
    }

    @Test
    public void onButtonClicked_MeasureTime_IsStopped() {
        threadsCount = "3";
        elementsCount = "100000";
        viewModel.onButtonClicked(elementsCount, threadsCount, isChecked);
        isChecked = false;
        viewModel.onButtonClicked(elementsCount, threadsCount, isChecked);
        verify(callbackFragment, times(1)).showMessage(R.string.calculation_is_stopped);
    }
}