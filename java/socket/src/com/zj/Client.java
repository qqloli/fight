package com.zj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("hello world");
            writer.flush();
            writer.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
