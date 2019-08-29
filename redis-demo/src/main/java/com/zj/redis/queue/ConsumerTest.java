package com.zj.redis.queue;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Random;

public class ConsumerTest implements Runnable{
    Jedis jedis = new Jedis("127.0.0.1",6379);

    public void run() {
        Random random = new Random();

        while (true){

            String taskid = jedis.rpoplpush("test","temp_test");

            try{
                Thread.sleep(random.nextInt(600)+600);

            }catch (Exception e){
                e.printStackTrace();
            }

            if (random.nextInt(13)%7==0){
                System.out.println("清除失败："+taskid);
                jedis.rpoplpush("temp_test","test");
            }else{
                jedis.rpop("temp_test");
                System.out.println("清除信息："+taskid);
            }

        }
    }
}
