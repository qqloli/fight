package com.zj.redis.sub_pub;

public class Client {
    private String name ;
    private RedisSubPubListener roomSubListerner;

    public Client(){
        roomSubListerner = new RedisSubPubListener();
    }

    public void setName(String name){
        this.name =name;
    }
    public String getName(){
        return name;
    }
    /* 进入房间*/
    public void subscribe(final String[] room){
        RedisSubPubListener roomSub = roomSubListerner;
        roomSub.setClientName(name);
        roomSub.setRoom(room);
        RedisUtil.subscribe(room, roomSub);
    }
    /* 退出房间*/
    public void unSubscribe(final String[] room){
        roomSubListerner.unsubscribe(room);
    }
    /*说话*/
    public void say(final String room,String message){
        RedisUtil.publish(room, name+" say:"+message);
    }

}
