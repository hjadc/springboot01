package com.huju.java8.service.impl;

import java.util.concurrent.RecursiveTask;

/**
 * 多线程并行任务,"窃取任务"工作
 * 继承 RecursiveAction 是没有返回值的
 * 继承 RecursiveTask<T> 是有返回值的
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    // 临界值,当拆到了10000就不再计算
    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long length = end - start;

        if (length <= THRESHOLD) {
            long sum = 0;

            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork(); //拆分，并将该子任务压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}