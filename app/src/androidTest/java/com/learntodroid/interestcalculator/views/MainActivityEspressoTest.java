package com.learntodroid.interestcalculator.views;

import com.learntodroid.interestcalculator.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkCalculation() {
        onView(withId(R.id.activity_main_initial_deposit_edit_text)).perform(click(), replaceText("10000"), closeSoftKeyboard());
        onView(withId(R.id.activity_main_monthly_deposit_edit_text)).perform(click(), replaceText("100"), closeSoftKeyboard());
        onView(withId(R.id.activity_main_interest_rate_edit_text)).perform(click(), replaceText("3"), closeSoftKeyboard());
        onView(withId(R.id.activity_main_term_edit_text)).perform(click(), replaceText("10"), closeSoftKeyboard());
        onView(withId(R.id.activity_main_calculate)).perform(click());

        onView(withId(R.id.activity_main_initial_deposit_edit_text)).check(matches(withText("10000")));
        onView(withId(R.id.activity_main_monthly_deposit_edit_text)).check(matches(withText("100")));
        onView(withId(R.id.activity_main_interest_rate_edit_text)).check(matches(withText("3")));
        onView(withId(R.id.activity_main_term_edit_text)).check(matches(withText("10")));

        RecyclerView recyclerView = rule.getActivity().findViewById(R.id.activity_main_recycler_view);
        assertEquals(3, recyclerView.getAdapter().getItemCount());

        onView(withId(R.id.activity_main_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withText("Total Deposits")).check(matches(isDisplayed()));

        onView(withId(R.id.activity_main_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withText("Total Interest")).check(matches(isDisplayed()));

        onView(withId(R.id.activity_main_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withText("Total Savings")).check(matches(isDisplayed()));
    }
}