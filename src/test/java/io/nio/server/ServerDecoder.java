package io.nio.server;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

public class ServerDecoder extends FrameDecoder{

	@Override
	protected Object decode(ChannelHandlerContext ctx, org.jboss.netty.channel.Channel channel,
			org.jboss.netty.buffer.ChannelBuffer buffer) throws Exception {
		if (buffer.readableBytes() < 8) {  
            return null;  
        }  
          
        int clientNo = buffer.readInt();  
        int index = buffer.readInt();  
        int a = buffer.readInt();  
        int b = buffer.readInt();  
  
        List<Integer> data = new ArrayList<Integer>();  
        data.add(clientNo);  
        data.add(index);  
        data.add(a);  
        data.add(b);  
          
        return data;
	}
	
}
