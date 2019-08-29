package com.zj.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultipleTimeService implements Runnable{
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean stop;

    public MultipleTimeService(int port){
        try{
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stop(){
        this.stop = true;
    }

    public void run() {
        while(!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {

                    } catch (Exception e){
                         if (key != null){
                             key.cancel();
                             if (key.channel()!= null){
                                 key.channel().close();
                             }
                         }
                    }
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
        }

        if (selector!=null){
            try{
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    private void handleInput(SelectionKey key) throws IOException{
        if (key.isValid()){
            if (key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes>0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String commond = new String(bytes,"UTF-8");
                    String currentTime = "query time order".equalsIgnoreCase(commond)?new java.util.Date(System.currentTimeMillis()).toString():"bad commond";

                }
            }
        }


    }

    private void doWriter(SocketChannel socketChannel,String currentTime) throws IOException{
        if (currentTime!=null && currentTime.trim().length()>0){
            byte[] bytes = currentTime.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
        }
    }



}
