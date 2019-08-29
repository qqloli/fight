package com.zj.rabbitMQ.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class BaseConnector {
    public String queueName;
    public Channel channel;
    public Connection connection;

    public BaseConnector(String queueName) throws IOException {
        this.queueName = queueName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queueName,false,false,false,null);
    }
}
