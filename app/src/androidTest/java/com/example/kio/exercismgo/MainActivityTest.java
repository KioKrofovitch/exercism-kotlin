package com.example.kio.exercismgo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by kio on 2/5/16.
 */
//TODO: run this code
// https://github.com/seadowg/deckard-kotlin/blob/master/src/androidTest/java/com/example/activity/DeckardEspressoTest.java
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void sanityCheck(){
        onView(withText("Hello World")).perform(click());
    }
}
