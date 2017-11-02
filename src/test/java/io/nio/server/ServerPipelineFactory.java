package io.nio.server;

import java.util.concurrent.ExecutorService;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;

public class ServerPipelineFactory implements ChannelPipelineFactory{
	private ExecutorService threadPool;  
	  
    public ServerPipelineFactory(ExecutorService threadPool) {  
        this.threadPool = threadPool;  
    }

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = Channels.pipeline();
        pipeline.addLast("framer", new ServerDecoder());  
        pipeline.addLast("handler", new ServerHandler(threadPool));
        return pipeline;  
	}  
      
}
