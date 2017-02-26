package com.concrete.bruno.concretetest.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by BRUNO on 26/02/2017.
 */

public class DateUtils {

    public static String convertDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
        Date dateNotFormatted = df.parse(date);
        DateFormat dfCorrect = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        return dfCorrect.format(dateNotFormatted);
    }

}
