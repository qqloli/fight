package com.zj.rabbitMQ;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

    //队列名称
    private final static String QUEUE_NAME = "queue";

    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false, false, false, null);

        String message = "hello world !";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        System.out.println("发送信息："+message);

        channel.close();

        connection.close();
    }
}
