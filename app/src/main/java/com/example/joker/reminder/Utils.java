package com.example.joker.reminder;

import java.text.SimpleDateFormat;

/**
 * Created by joker on 21.01.16.
 */
public class Utils {

    public static String getDate(Long date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(date);
    }

    public static String getTime(long time){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH.mm");
        return  timeFormat.format(time);
    }

    public static String getFullDate(long date){
        SimpleDateFormat fullDateFormat = new SimpleDateFormat("dd.MM.yy  HH.mm");
        return fullDateFormat.format(date);
    }
}
