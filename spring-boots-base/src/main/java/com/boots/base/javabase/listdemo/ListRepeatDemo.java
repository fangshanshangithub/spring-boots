package com.boots.base.javabase.listdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListRepeatDemo {

    public static void main(String[] args) {
        System.out.println("ListRepeatDemo.main   "+ secondToDate( 1560761654,"yyyy-MM-dd hh:mm:ss"));

    }

    private static Date secondToDate(long second, String patten) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second * 1000);//转换为毫秒
        Date date = calendar.getTime();
        return date;
    }

}
