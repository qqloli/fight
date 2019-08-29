package com.zj.rabbitMQ.test1;

import com.zj.rabbitMQ.util.BaseConnector;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Sender extends BaseConnector {

    public Sender(String queueName) throws IOException {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException{
        channel.basicPublish("",queueName,null, SerializationUtils.serialize(object));
    }
}
