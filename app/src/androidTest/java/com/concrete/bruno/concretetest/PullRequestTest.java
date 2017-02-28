package com.concrete.bruno.concretetest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.concrete.bruno.concretetest.model.PullRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Created by Bruno on 28/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class PullRequestTest {

    @Test
    public void convertJsonToObject() throws IOException{
        Context appContext = InstrumentationRegistry.getTargetContext();

        String expectedTitle = "Adjusted the getUsers()";
        String expectedHtmlUrl = "http://someurl.com/pulls/2211";
        String expectedUserLogin = "loginexample";
        String expectedAvatarUrl = "http://someavatar.com/2277";
        String expectedBody = "The method was not returning the right users";
        String expectedCreatedAt = "2017-02-28T12:09:01Z";
        String expectedClosedAt = null;

        ObjectMapper mapper = new ObjectMapper();

        PullRequest pullRequest = mapper.readValue(appContext.getAssets().open("pull_request.json"), PullRequest.class);

        Assert.assertEquals(expectedTitle, pullRequest.getTitle());
        Assert.assertEquals(expectedHtmlUrl, pullRequest.getUrl());
        Assert.assertEquals(expectedUserLogin, pullRequest.getUserPullRequest().getLogin());
        Assert.assertEquals(expectedAvatarUrl, pullRequest.getUserPullRequest().getAvatarUrl());
        Assert.assertEquals(expectedBody, pullRequest.getBody());
        Assert.assertEquals(expectedCreatedAt, pullRequest.getCreatedAt());
        Assert.assertEquals(expectedClosedAt, pullRequest.getClosedAt());
    }

}
