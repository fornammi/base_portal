package io.nio.netty;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
    	System.out.println("server handler channelRead ...");
    	/**
    	 * 缓冲内容复制到字节数组
    	 */
    	ByteBuf buf = (ByteBuf)msg;
    	int size = buf.readableBytes();
    	byte[] reqByte = new byte[size];
    	//复制内容到字节数组b
    	buf.readBytes(reqByte);
    	String req = new String(reqByte, "UTF-8");
    	System.out.println(">>>>>handler receive msg(String):"+req);
    	String respStr = "[matches failure]no resp";
    	if("nammi".equals(req)){
    		respStr = "[matches success]hello,"+req;
    	}
    	System.out.println(">>>>>handler resp msg(String):"+respStr);
    	ByteBuf resp = Unpooled.copiedBuffer((respStr+"/r/n").getBytes());
    	ctx.write(resp);//write的内容必须为ByteBuf，否则dos界面是空白
    	/**
    	 * 简单测试：打印请求内容
    	 */
    	//>>>>>handler receive msg:UnpooledUnsafeDirectByteBuf(ridx: 0, widx: 1, cap: 448)
    	/*System.out.println(">>>>>handler receive msg:"+msg);
    	ctx.writeAndFlush(msg);*/
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
    	//System.out.println("server channelReadComplete..");
        ctx.flush();//刷新后才将数据发出到SocketChannel
    }
}
