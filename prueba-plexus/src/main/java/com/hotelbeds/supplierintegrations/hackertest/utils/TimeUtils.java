package com.hotelbeds.supplierintegrations.hackertest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeUtils {
	
	public static double compareTimes(long now,long then) {
		double minutes = Math.floor((now - then)/60);
		return Math.abs(minutes);
	}
	
	public static String rfc2822(Date date) {
        String pattern = "EEE, dd MMM yyyy HH:mm:ss Z";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


}
