package com.csf.common.serialization;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by hand on 2019/1/8.
 */
public class Test {


    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int week = cal.get(Calendar.WEEK_OF_MONTH);
        System.out.println(week);
    }

}
