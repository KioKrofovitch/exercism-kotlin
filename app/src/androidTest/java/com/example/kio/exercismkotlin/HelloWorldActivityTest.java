package com.example.kio.exercismkotlin;

import android.support.test.espresso.ViewInteraction;
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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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
        onNameEditText().check(matches(isDisplayed()));
        onGreetingButton().check(matches(isDisplayed()));
        onGreetingText().check(matches(isDisplayed()));
    }

    @Test
    public void testEmptyGreeting(){
        onNameEditText().perform(clearText());
        onGreetingButton().perform(click());
        onGreetingText().check(matches(withText("Hello, World!")));
    }

    @Test
    public void testNamedGreeting(){
        onNameEditText().perform(replaceText("Kio Krofovitch"));
        onGreetingButton().perform(click());
        onGreetingText().check(matches(withText("Hello, Kio Krofovitch!")));
    }

    private ViewInteraction onNameEditText(){
        return onView(withId(R.id.edit_name));
    }

    private ViewInteraction onGreetingButton(){
        return onView(withId(R.id.button_greeting));
    }

    private ViewInteraction onGreetingText(){
        return onView(withId(R.id.text_hello_main));
    }
}
