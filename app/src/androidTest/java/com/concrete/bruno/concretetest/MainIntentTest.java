package com.concrete.bruno.concretetest;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.concrete.bruno.concretetest.ui.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Bruno on 28/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainIntentTest {

    @Rule
    public IntentsTestRule<MainActivity> activityIntentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void callIntentTest(){
        onView(withId(R.id.recycler_repository)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        intended(toPackage("com.concrete.bruno.concretetest"));
    }

}
