package com.xu.xu7x;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xuhongda on 2019/7/3
 * com.xu.xu7x
 * xu7x
 */
public class TimeTest {
    @Test
    public void test1() {
        long l = System.currentTimeMillis();
        Date date = new Date();
        date.setTime(l);

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.MONTH, 7);
        instance.set(Calendar.DAY_OF_MONTH, 7);

        Date time = instance.getTime();
        long time1 = time.getTime();

        System.out.println(l);
        System.out.println(time1);
    }


    @Test
    public void test2() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());

        int i = instance.get(Calendar.MONTH);
        System.out.println(i);

        int weekYear = instance.getWeekYear();
        System.out.println(weekYear);
    }
}
