package io.nio.server;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;


public class ServerHandler extends SimpleChannelHandler {
	private ExecutorService threadPool;  
	  
    public ServerHandler(ExecutorService threadPool) {  
        this.threadPool = threadPool;  
    }  
    @Override  
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws InterruptedException {  
        /* 
         * ChannelBuffer buf = (ChannelBuffer)e.getMessage(); byte[] des = 
         * buf.array(); String recvText = new String(des, 0, des.length); 
         * System.out.println(recvText); Channel ch = e.getChannel(); 
         * ch.write(e.getMessage()); 
         */  
          
        List<Integer> data = (List<Integer>) e.getMessage();  
        HandleTask ht = new HandleTask(e);  
        threadPool.submit(ht);  
          
        int clientNo = data.get(0);  
        int index = data.get(1);  
        int a = data.get(2);  
        int b = data.get(3);  
  
        String content = String.format("client: %d, index: %d, a: %d, b: %d", clientNo, index, a, b);  
        System.out.println(content);  
          
        Channel ch = e.getChannel();  
        ChannelBuffer buf = ChannelBuffers.buffer(4);  
        buf.writeInt(a+b);  
        ch.write(buf);  
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {  
        e.getCause().printStackTrace();  
  
        Channel ch = e.getChannel();  
        ch.close();  
    }
}



class HandleTask implements Runnable {  
    MessageEvent e;  
      
    public HandleTask(MessageEvent e) {  
        this.e = e;  
    }  
      
    public void run() {  
        List<Integer> data = (List<Integer>) e.getMessage();  
          
        int clientNo = data.get(0);  
        int index = data.get(1);  
        int a = data.get(2);  
        int b = data.get(3);  
  
        String content = String.format("client: %d, index: %d, a: %d, b: %d", clientNo, index, a, b);  
        System.out.println(content);  
          
        Channel ch = e.getChannel();  
        ChannelBuffer buf = ChannelBuffers.buffer(4);  
        buf.writeInt(a+b);  
        ch.write(buf);  
    }  
} 
