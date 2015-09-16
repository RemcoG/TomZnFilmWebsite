package com.tom.util;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 9-9-2015.
 */
public class StringToDate {
    public static DateTime stringToDate(String str){
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
            return new DateTime(format.parse(str));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new DateTime();
    }
}
