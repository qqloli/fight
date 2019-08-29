package com.zj.redis.queue;

public class TaskShedulerSystem {
    public static void main(String[] args) throws Exception{
        // 启动一个生产者线程，模拟任务的产生
        new Thread(new ProducerTest()).start();

        Thread.sleep(15000);

        //启动一个线程者线程，模拟任务的处理
        new Thread(new ConsumerTest()).start();

        //主线程休眠
        Thread.sleep(Long.MAX_VALUE);

    }
}
