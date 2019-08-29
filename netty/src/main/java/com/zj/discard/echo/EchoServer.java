package com.zj.discard.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;

public class EchoServer {

    private int port;

    public EchoServer(int port){
        this.port=port;
    }

    public void run() throws Exception{
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss,worker)
                            .channel(NioServerSocketChannel.class)
                            .handler(new LoggingHandler())
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    socketChannel.pipeline().addLast(new EchoServerHandler());
                                }
                            })
                            .option(ChannelOption.SO_BACKLOG, 128)
                             .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture future = serverBootstrap.bind(port).sync();

            future.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port =8088;
        try{
            EchoServer echoServer = new EchoServer(port);
            echoServer.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
