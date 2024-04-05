package com.tweets.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static String now(){
            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
            String strDate = dateFormat.format(date);  
            return strDate;
    }
}
