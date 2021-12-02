package com.example.ticketer;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.ticketer.view_controller.MainActivity;

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

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    private String word="TestKeyword";
    @Test
    public void testUsernameTextbox() throws Exception{

        onView(withId(R.id.username)).perform(typeText(word));
        closeSoftKeyboard();
        onView(withId(R.id.username)).check(matches(withText(word)));

    }

    @Test
    public void testPasswordTextbox() throws Exception{

        onView(withId(R.id.password)).perform(typeText(word));
        closeSoftKeyboard();
        onView(withId(R.id.password)).check(matches(withText(word)));

    }


}
