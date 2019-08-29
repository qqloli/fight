package com.zj.discard.talk;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class TalkClient {
    private int port;
    private String host;

    public TalkClient(String host,int port){
       this.host=host;
       this.port=port;
    }

    public void run() throws Exception{
        NioEventLoopGroup worker = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                     .channel(NioSocketChannel.class)
                     .handler(new ChannelInitializer<SocketChannel>() {
                         protected void initChannel(SocketChannel ch) throws Exception {
                             ChannelPipeline p = ch.pipeline();
                             p.addLast(new StringDecoder());
                             p.addLast(new StringEncoder());
                             p.addLast(new TalkClientHanlder());
                             p.addLast(new TalkClientHanlder());
                         }
                     })
                    .option(ChannelOption.TCP_NODELAY, true);


            ChannelFuture future = bootstrap.connect(host,port).sync();
            future.channel().writeAndFlush("这里是客户端，请求连接服务端！");
            future.channel().closeFuture().sync();
        }finally {
            worker.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        String host ="127.0.0.1";
        int port = 8088;
        try {
            TalkClient talkClient = new TalkClient(host,port);
            talkClient.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
