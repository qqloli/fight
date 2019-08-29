package com.zj.redis.queue;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.UUID;

public class ProducerTest implements Runnable{
    Jedis jedis = new Jedis("127.0.0.1",6379);

    public void run() {
        Random random = new Random();
        while (true){
          try{
              Thread.sleep(random.nextInt(600)+600);
              UUID uuid = UUID.randomUUID();
              jedis.lpush("test", uuid.toString());
              System.out.println("发送了信息："+uuid.toString());
          }catch (Exception e){
            e.printStackTrace();
          }
        }

    }



}
