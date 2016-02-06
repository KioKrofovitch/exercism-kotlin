package com.kiodev.exercismkotlin;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * UI Tests for Leap Year
 */
@RunWith(AndroidJUnit4.class)
public class LeapYearActivityTest {


    @Rule
    public ActivityTestRule<LeapYearActivity> activityTestRule =
            new ActivityTestRule<>(LeapYearActivity.class);

    @Test
    public void testUiExists(){
        onYearEditText().check(matches(isDisplayed()));
        onCheckYearButton().check(matches(isDisplayed()));
        onCommentsText().check(matches(isDisplayed()));
    }

    @Test
    public void testEmptyYear(){
        onYearEditText().perform(clearText());
        onCheckYearButton().perform(click());
        onCommentsText().check(matches(withText(R.string.bad_data)));
    }

    @Test
    public void testBadData(){
        onYearEditText().perform(clearText());
        onCheckYearButton().perform(click());
        onCommentsText().check(matches(withText(R.string.bad_data)));
    }

    @Test
    public void testActualYears(){
        HashMap<Integer,Boolean> leapYearMap = new HashMap<>();
        leapYearMap.put(1996, true);
        leapYearMap.put(1997, false);
        leapYearMap.put(1998, false);
        leapYearMap.put(1900, false);
        leapYearMap.put(2400, true);
        leapYearMap.put(2000, true);


        for(Map.Entry<Integer,Boolean> entry : leapYearMap.entrySet()){
            String yearString = entry.getKey().toString();
            onYearEditText().perform(replaceText(yearString));

            onCheckYearButton().perform(click());

            int expectedTextId = getExpectedYearText(entry.getValue());
            onCommentsText().check(matches(withText(expectedTextId)));
        }
    }

    private int getExpectedYearText(boolean isLeapYear) {
        if(isLeapYear)
            return R.string.leap_year;
        else
            return R.string.non_leap_year;
    }

    private ViewInteraction onYearEditText(){
        return onView(withId(R.id.edit_year));
    }

    private ViewInteraction onCheckYearButton(){
        return onView(withId(R.id.button_check_year));
    }

    private ViewInteraction onCommentsText(){
        return onView(withId(R.id.text_comment));
    }
}
