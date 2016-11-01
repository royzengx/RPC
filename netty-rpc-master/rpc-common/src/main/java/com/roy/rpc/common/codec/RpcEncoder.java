package com.roy.rpc.common.codec;

import com.roy.rpc.common.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 
 * @author Roy
 *
 */
public class RpcEncoder extends MessageToByteEncoder<Object> {

    private Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, ByteBuf byteBuf) throws Exception {
        if (genericClass.isInstance(obj)) {
            byte[] data = SerializationUtil.serializer(obj);
            byteBuf.writeInt(data.length);
            byteBuf.writeBytes(data);
        }
    }
}
