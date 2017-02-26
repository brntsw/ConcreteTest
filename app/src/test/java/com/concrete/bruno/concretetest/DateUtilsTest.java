package com.concrete.bruno.concretetest;

import com.concrete.bruno.concretetest.utils.DateUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by BRUNO on 26/02/2017.
 */

public class DateUtilsTest {
    @Test
    public void convertDateTest() throws Exception{
        String dateToBeConverted = "2017-02-26T14:37:30Z";

        //The output must be 26/02/2017
        String expectedOutputFormattedDate = "26/02/2017";

        Assert.assertEquals(expectedOutputFormattedDate, DateUtils.convertDate(dateToBeConverted));
    }
}
