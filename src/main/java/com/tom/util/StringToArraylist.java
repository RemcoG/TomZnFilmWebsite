package com.tom.util;

import java.util.ArrayList;

/**
 * Created by Tom on 9-9-2015.
 */
public class StringToArraylist {

    public static ArrayList<String> stringToArraylist(String str){
        ArrayList<String> list = new ArrayList<String>();
        String[] arrStr = str.split(",");
        for(String p : arrStr)
            list.add(p);
        return list;
    }
}
