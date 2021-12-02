package com.example.ticketer;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.ticketer.view_controller.BusDetails;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest


public class BusDetailsTest {



    @Rule
    public ActivityTestRule<BusDetails> mActivityRule = new ActivityTestRule(BusDetails.class);

    private String word="AAA-123";
    @Test
    public void TestBusInput() throws Exception{

        onView(withId(R.id.vehiclenumber)).perform(typeText(word));
        closeSoftKeyboard();
        onView(withId(R.id.vehiclenumber)).check(matches(withText(word)));
    }

}
