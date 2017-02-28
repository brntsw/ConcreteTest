package com.concrete.bruno.concretetest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.concrete.bruno.concretetest.model.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Created by Bruno on 28/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class RepositoryTest {

    @Test
    public void convertJsonToObject() throws IOException{
        Context appContext = InstrumentationRegistry.getTargetContext();

        String expectedName = "RxJava";
        String expectedFullName = "ReactiveX/RxJava";
        String expectedDescription = "This is the RxJava repository";
        int expectedForksCount = 1200;
        int expectedStarsCount = 7561;
        String expectedOwnerName = "examplelogin";
        String expectedAvatarUrl = "http://someavatar.com/123";

        ObjectMapper mapper = new ObjectMapper();

        Repository repository = mapper.readValue(appContext.getAssets().open("repository.json"), Repository.class);

        Assert.assertEquals(expectedName, repository.getName());
        Assert.assertEquals(expectedFullName, repository.getFullName());
        Assert.assertEquals(expectedDescription, repository.getDescription());
        Assert.assertEquals(expectedForksCount, repository.getNumberForks());
        Assert.assertEquals(expectedStarsCount, repository.getStarGazersCount());
        Assert.assertEquals(expectedOwnerName, repository.getOwner().getName());
        Assert.assertEquals(expectedAvatarUrl, repository.getOwner().getAvatarUrl());
    }

}
