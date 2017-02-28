package com.concrete.bruno.concretetest;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.concrete.bruno.concretetest.model.Repository;
import com.concrete.bruno.concretetest.ui.activity.MainActivity;
import com.concrete.bruno.concretetest.ui.adapter.RepositoryAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Bruno on 28/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateToolbarTitle(){
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar)))).check(matches(withText(R.string.app_name)));
    }

    @Test
    public void validateMockClickRecyclerRepository() throws IOException {
        RecyclerView recyclerView = Mockito.mock(RecyclerView.class);

        ObjectMapper mapper = new ObjectMapper();

        List<Repository> repositories = new ArrayList<>();
        Repository repository = mapper.readValue(mActivityRule.getActivity().getAssets().open("repository.json"), Repository.class);
        repositories.add(repository);

        RepositoryAdapter adapter = new RepositoryAdapter(mActivityRule.getActivity(), repositories);
        recyclerView.setAdapter(adapter);

        recyclerView.getChildAt(0).performClick();
    }

    @Test
    public void validateClickRecyclerRepository(){
        onView(withId(R.id.recycler_repository)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void validateToolbarTitlePullRequestActivity(){
        onView(withId(R.id.recycler_repository)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar)))).check(matches(withText("ReactiveX/RxJava")));
    }
}
