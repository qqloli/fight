package com.zj.rabbitMQ.test1;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Receiver receiver = new Receiver("test");
        Thread thread = new Thread(receiver);
        thread.start();

        Sender sender = new Sender("test");
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setChannel("test");
            user.setContent("num"+i);
            sender.sendMessage(user);
        }
    }
}
