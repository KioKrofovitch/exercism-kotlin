package com.example.kio.exercismkotlin;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringEndsWith.endsWith;

/**
 * UI Tests for Hello World
 */
@RunWith(AndroidJUnit4.class)
public class HelloWorldActivityTest {

    @Rule
    public ActivityTestRule<HelloWorldActivity> activityTestRule =
            new ActivityTestRule<>(HelloWorldActivity.class);

    @Test
    public void testUiExists(){
        onView(withClassName(endsWith("EditText")))
                .check(matches(isDisplayed()));

        onView(withClassName(endsWith("Button")))
                .check(matches(isDisplayed()));

        onView(withClassName(endsWith("TextView")))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testEmptyGreeting(){
        onView(withClassName(endsWith("EditText")))
                .perform(clearText());

        onView(withClassName(endsWith("Button"))).perform(click());

        onView(withClassName(endsWith("TextView")))
                .check(matches(withText("Hello, World!")));
    }

    @Test
    public void testNamedGreeting(){
        onView(withClassName(endsWith("EditText")))
                .perform(replaceText("Kio Krofovitch"));

        onView(withClassName(endsWith("Button"))).perform(click());

        onView(withClassName(endsWith("TextView")))
                .check(matches(withText("Hellow, Kio Krofovitch!")));
    }
}
