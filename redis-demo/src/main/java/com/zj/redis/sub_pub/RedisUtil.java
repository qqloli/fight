package com.zj.redis.sub_pub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Scanner;

public class RedisUtil {

    private static JedisPool jedisPool;

    private RedisUtil(){}

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(1);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setNumTestsPerEvictionRun(10);
        poolConfig.setTimeBetweenEvictionRunsMillis(60000);
        poolConfig.setMaxWaitMillis(10000);

        jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379);

    }

     public static void publish(String channel,String message){
         Jedis jedis = jedisPool.getResource();
         jedis.publish(channel,message);
     }

     public static  void subscribe(String[] room,RedisSubPubListener listener){
        Jedis jedis = jedisPool.getResource();
        jedis.subscribe(listener,room);
     }


    public static void main(String[] args) throws InterruptedException {
        final Client client = new Client();
        client.setName("Jacker");
        final String[] rooms = {"movie::live::room"};
        new Thread(new Runnable() {
            public void run() {
//              String[] rooms = {"peter::live::room","Bob::live::room"};
                client.subscribe(rooms);
            }
        }).start();
        Thread.sleep(3000);
        while(true){
            System.out.print("say something:");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if("quit".equals(message)){
                break;
            }else{
                client.say(rooms[0], message);
                System.out.println();
            }
        }
        String[] unSubRoom ={"movie::live::room"};
        client.unSubscribe(unSubRoom);
    }

}
