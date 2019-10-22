package com.learntodroid.interestcalculator.views;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.learntodroid.interestcalculator.R;
import com.learntodroid.interestcalculator.adapters.ResultsAdapter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkTextInputLayoutPresent() throws Exception {
        MainActivity activity = rule.getActivity();

        View initialDeposit = activity.findViewById(R.id.activity_main_initial_deposit);
        assertThat(initialDeposit, notNullValue());
        assertThat(initialDeposit, instanceOf(TextInputLayout.class));

        View monthlyDeposit = activity.findViewById(R.id.activity_main_monthly_deposit);
        assertThat(monthlyDeposit, notNullValue());
        assertThat(monthlyDeposit, instanceOf(TextInputLayout.class));

        View interestRate = activity.findViewById(R.id.activity_main_interest_rate);
        assertThat(interestRate, notNullValue());
        assertThat(interestRate, instanceOf(TextInputLayout.class));

        View term = activity.findViewById(R.id.activity_main_term);
        assertThat(term, notNullValue());
        assertThat(term, instanceOf(TextInputLayout.class));
    }

    @Test
    public void checkCalculateButtonPresent() throws Exception {
        MainActivity activity = rule.getActivity();

        View calculate = activity.findViewById(R.id.activity_main_calculate);
        assertThat(calculate, notNullValue());
        assertThat(calculate, instanceOf(Button.class));
    }

    @Test
    public void checkRecyclerViewPresent() throws Exception {
        MainActivity activity = rule.getActivity();

        RecyclerView recyclerView = activity.findViewById(R.id.activity_main_recycler_view);
        ResultsAdapter adapter = (ResultsAdapter) recyclerView.getAdapter();
        assertThat(adapter, instanceOf(ResultsAdapter.class));
        assertThat(adapter.getItemCount(), equalTo(0));
    }
}