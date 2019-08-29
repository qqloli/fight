package com.zj.rabbitMQ.test1;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.zj.rabbitMQ.util.BaseConnector;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

public class Receiver extends BaseConnector implements Runnable, Consumer {

    public Receiver(String queueName) throws IOException {
        super(queueName);
    }

    public void run() {
        try{
            channel.basicConsume(queueName,true,this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleConsumeOk(String s) {
        System.out.println("Consumer "+s +" registered");
    }

    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        User messageInfo = (User) SerializationUtils.deserialize(bytes);
        System.out.println("Message ( "
                + "channel : " + messageInfo.getChannel()
                + " , content : " + messageInfo.getContent()
                + " ) received.");
    }


}
