package com.huju.java8.test;

import com.huju.java8.service.impl.ForkJoinCalculate;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * 测试多线程计算,实际用到的不多
 */
public class TestForkJoin {

    /**
     * 用 ForkJoin 框架计算 1到一亿的累加总和
     */
    @Test
    public void test1() {

        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 5000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("共耗时:" + Duration.between(start, end).toMillis() + "毫秒");
    }

    /**
     * 用 普通for循环计算 1到一亿的累加总和
     */
    @Test
    public void test2() {
        Instant start = Instant.now();
        long sum = 0L;

        for (long i = 0; i <= 5000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("共耗时:" + Duration.between(start, end).toMillis() + "毫秒");

    }

    /**
     * 用 java8并行流计算 1到一亿的累加总和
     */
    @Test
    public void test3() {

        Instant start = Instant.now();

        long reduce = LongStream.rangeClosed(0, 5000000000L).parallel().reduce(0, Long::sum);

        System.out.println(reduce);

        Instant end = Instant.now();
        System.out.println("共耗时:" + Duration.between(start, end).toMillis() + "毫秒");

    }
}
