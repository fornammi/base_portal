package io.nio.netty;

import java.util.concurrent.ExecutionException;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * netty server端
 * @author daniel.fang
 * 
 * 测试：telnet 127.0.0.1 8001
 */
public class NettyServer {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 8001;
	private static final int BOSS_GROUP_SIZE = Runtime.getRuntime().availableProcessors()*2;
	private static final int WORKER_GROUP_SIZE = 100;
	private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BOSS_GROUP_SIZE);
	private static final EventLoopGroup workerGroup = new NioEventLoopGroup(WORKER_GROUP_SIZE);
	
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.handler(new LoggingHandler(LogLevel.DEBUG));
            bootstrap.childHandler(new ChannelInitializer<Channel>() {
				@Override
				public void initChannel(Channel ch) throws Exception {
				    ChannelPipeline p = ch.pipeline();
				    p.addLast(new NettyServerHandler());
				}
            });
            // Start the client.
            ChannelFuture cf = bootstrap.bind(HOST, PORT).sync();
            System.out.println("start server success, you can telnet "+HOST+" "+PORT+" to send massage for this server");
            // Wait until the connection is closed.
            cf.channel().closeFuture().sync();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
