package com.zj.discard.talk;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;

public class TalkServer {
    private int port;

    public TalkServer(int port){
        this.port=port;
    }

    public void run() throws Exception{
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss,worker)
                           .channel(NioServerSocketChannel.class)
                           .handler(new LoggingHandler())
                           .childHandler(new ChannelInitializer<SocketChannel>() {
                               protected void initChannel(SocketChannel ch) throws Exception {
                                   ChannelPipeline p = ch.pipeline();
                                   p.addLast(new StringDecoder());
                                   p.addLast(new StringEncoder());
                                   p.addLast(new TalkServerHandler());
                               }
                           })
                           .option(ChannelOption.SO_BACKLOG,128)
                           .childOption(ChannelOption.SO_KEEPALIVE,true);

            ChannelFuture future = serverBootstrap.bind(port).sync();
            System.out.println("8099:binded...");
            future.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        String host ="127.0.0.1";
        int port = 8088;
        try {
            TalkServer talkServer = new TalkServer(port);
            //TalkClient talkClient = new TalkClient(host,port);
            talkServer.run();
            //talkClient.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
