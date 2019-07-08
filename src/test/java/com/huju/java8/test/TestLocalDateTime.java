package com.huju.java8.test;

import org.junit.Test;

import java.time.LocalDateTime;

public class TestLocalDateTime {

    @Test
    public void test1() {
        // 获取当前时间的LocalDateTime实例
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("当前时间:" + ldt);

        // 获取指定时间的LocalDateTime实例
        LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
        System.out.println(ld2);

        // 当前时间加两年
        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println("往后两年的当前时间:" + ldt3);

        // 当前时间减两年
        System.out.println("往前两年当前时间:" + ldt.minusYears(2));

        // 当前时间加两个月
        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println("减两个月的当前时间:" + ldt4);

        // 获取年
        System.out.println("当前年:" + ldt.getYear());
        // 获取月
        System.out.println("当前月:" + ldt.getMonthValue());
        // 获取日
        System.out.println("当前日:" + ldt.getDayOfMonth());
        // 获取时
        System.out.println("当前时:" + ldt.getHour());
        // 获取分
        System.out.println("当前分:" + ldt.getMinute());
        // 获取秒
        System.out.println("当前秒:" + ldt.getSecond());
    }
}
