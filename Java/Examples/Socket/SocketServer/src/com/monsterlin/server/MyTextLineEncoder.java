package com.monsterlin.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * _            _ _
 * _ __ ___   ___  _ __  ___| |_ ___ _ __| (_)_ __    ___ ___  _ __ ___
 * | '_ ` _ \ / _ \| '_ \/ __| __/ _ \ '__| | | '_ \  / __/ _ \| '_ ` _ \
 * | | | | | | (_) | | | \__ \ ||  __/ |  | | | | | || (_| (_) | | | | | |
 * |_| |_| |_|\___/|_| |_|___/\__\___|_|  |_|_|_| |_(_)___\___/|_| |_| |_|
 *
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 加密
 * @date : 2018/9/25 11:24 PM
 */
public class MyTextLineEncoder implements ProtocolEncoder {
    @Override
    public void encode(IoSession ioSession, Object message, ProtocolEncoderOutput out) throws Exception {
        String s = null;
        if (message instanceof String) {
            s = (String) message;
        }

        if (s != null) {
            //获取系统默认的编码方式
            CharsetEncoder charsetEncoder = (CharsetEncoder) ioSession.getAttribute("encoder");
            if (charsetEncoder == null) {
                charsetEncoder = Charset.defaultCharset().newEncoder();
                ioSession.setAttribute("encoder", charsetEncoder);
            }

            //IoBuffer转字节

            //开辟内存
            IoBuffer ioBuffer = IoBuffer.allocate(s.length());
            //自动扩展内存
            ioBuffer.setAutoExpand(true);
            ioBuffer.putString(s, charsetEncoder);
            ioBuffer.flip();
            out.write(ioBuffer);
        }
    }

    @Override
    public void dispose(IoSession ioSession) throws Exception {

    }
}
