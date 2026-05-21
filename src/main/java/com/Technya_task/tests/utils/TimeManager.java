package com.Techneya_task.tests.utils;

public class TimeManager {
    //unique timestamp for each data
    public static String getSimpleTimestamp() {
        return Long.toString(System.currentTimeMillis());
    }

    //screenshots - logs - reports
    public static String getTimestamp() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());
    }
}
