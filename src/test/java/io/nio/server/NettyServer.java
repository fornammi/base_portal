package io.nio.server;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class NettyServer {
	static final ChannelGroup allChannels = new DefaultChannelGroup("time-server");  
    
    public static void main(String[] args) throws Exception {  
        ExecutorService threadPool = Executors.newFixedThreadPool(5);  
          
        ChannelFactory factory = new NioServerSocketChannelFactory(  
                Executors.newCachedThreadPool(),  
                Executors.newCachedThreadPool());  
  
        ServerBootstrap bootstrap = new ServerBootstrap(factory);  
  
        bootstrap.setPipelineFactory(new ServerPipelineFactory(threadPool));  
          
        bootstrap.setOption("child.tcpNoDelay", true);  
        bootstrap.setOption("child.keepAlive", true);  
  
        System.out.println("Netty Server start...");  
        Channel channel = bootstrap.bind(new InetSocketAddress(8080));  
          
/*      allChannels.add(channel); 
        System.out.println("1111111111111111111"); 
        Thread.sleep(2*60*1000); 
        System.out.println("2222222222222222222"); 
        ChannelGroupFuture future = allChannels.close(); 
        future.awaitUninterruptibly(); 
        factory.releaseExternalResources(); 
        System.out.println("3333333333333333333");*/  
          
    }
}
