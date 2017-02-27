package com.concrete.bruno.concretetest.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by BRUNO on 26/02/2017.
 */

public class ImageUtils {

    public static int getMeasureProfileImage(Context context){
        switch (context.getResources().getDisplayMetrics().densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                return 27;
            case DisplayMetrics.DENSITY_MEDIUM:
                return 36;
            case DisplayMetrics.DENSITY_HIGH:
                return 54;
            case DisplayMetrics.DENSITY_XHIGH:
                return 72;
            case DisplayMetrics.DENSITY_XXHIGH:
                return 108;
            case DisplayMetrics.DENSITY_XXXHIGH:
                return 144;
            default:
                return 50;
        }
    }

}
