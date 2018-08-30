package me.personal.progress.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by zhongyi on 2018/4/11.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
    private static int num = 0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        System.out.println("channelRead "+ ++num);

        //Discard the received data silently.
        //((ByteBuf)msg).release();

        ByteBuf in = (ByteBuf) msg;
        try {
            // (1)  System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII))
            while (in.isReadable()) {
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        }  finally {
            //in.release()
            ReferenceCountUtil.release(msg); // (2)
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
