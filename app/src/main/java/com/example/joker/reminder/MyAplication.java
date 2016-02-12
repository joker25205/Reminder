package com.example.joker.reminder;

import android.app.Application;

/**
 * Created by joker on 30.01.16.
 */
public class MyAplication extends Application {

    private static boolean activityVisible;

    public static boolean isActivityVisible(){
        return activityVisible;
    }

    public static void activityResumed(){
        activityVisible = true;
    }

    public static void activityPaused(){
        activityVisible = false;
    }
}
