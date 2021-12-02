package com.example.ticketer;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.ticketer.view_controller.ViewSeats;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest


public class ViewSeatsTest {


    @Rule
    public ActivityTestRule<ViewSeats> mActivityRule = new ActivityTestRule(ViewSeats.class);

    private String word="AAA-123";
    @Test
    public void TestSeatSelection() throws Exception{

        onView(withId(R.id.a1)).perform(click());
        onView(withId(R.id.a2)).perform(click());
        onView(withId(R.id.b14)).perform(click());
        onView(withId(R.id.a1)).perform(click());
        onView(withId(R.id.a2)).perform(click());
        onView(withId(R.id.b14)).perform(click());
        onView(withId(R.id.a5)).perform(click());
        onView(withId(R.id.b9)).perform(click());

    }



}
