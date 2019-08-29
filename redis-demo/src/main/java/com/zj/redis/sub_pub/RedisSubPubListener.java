package com.zj.redis.sub_pub;

import redis.clients.jedis.JedisPubSub;

public class RedisSubPubListener extends JedisPubSub {
    /*成员名字*/
    private String clientName;
    /*房间名*/
    private String[] room;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String[] getRoom() {
        return room;
    }

    public void setRoom(String[] room) {
        this.room = room;
    }


    public void onMessage(String channel, String message) {
        System.out.println("收到来自"+channel+"房间的消息："+message);
    }

    public void onPMessage(String pattern, String channel, String message) {

    }

    public void onSubscribe(String channel, int subscribedChannels) {
        RedisUtil.publish( channel,clientName+ "进入房间");
    }

    public void unsubscribe(String channel, int subscribedChannels) {

            RedisUtil.publish(channel, clientName+"离开房间");

    }

    public void onPUnsubscribe(String pattern, int subscribedChannels) {
    }

    public void onPSubscribe(String pattern, int subscribedChannels) {
    }

    public void onPong(String pattern) {
    }
}
