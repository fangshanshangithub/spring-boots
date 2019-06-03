package com.boots.base.javabase.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        System.out.println(getPreDays(1));
    }

    /**
     * 获取 提前几天的long值
     * @param days
     * @return
     */
    public static Long getPreDays(int days){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        Date date = calendar.getTime();

        String startTime = sdf.format(date);
        System.out.println(startTime);
        return date.getTime();



    }
}
