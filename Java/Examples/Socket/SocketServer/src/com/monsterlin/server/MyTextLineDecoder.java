package com.monsterlin.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

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
 * @desc : 解密
 * @date : 2018/9/25 11:24 PM
 */
public class MyTextLineDecoder implements ProtocolDecoder {
    @Override
    public void decode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput out) throws Exception {
        int startPosition = ioBuffer.position();

        //判断是否有字节可以读取
        while (ioBuffer.hasRemaining()){
            byte b = ioBuffer.get();
            if (b=='\n'){
                //字节转IoBuffer，进而转换为字符串

                int currentPosition = ioBuffer.position();
                int limit = ioBuffer.limit();
                ioBuffer.position(startPosition);
                ioBuffer.limit(currentPosition);

                //截取
                IoBuffer buf = ioBuffer.slice();
                byte[] dest = new byte[buf.limit()];

                //ioBuffer的字节复制到buf
                buf.get(dest);

                String str = new String(dest);
                out.write(str);

                //还原
                ioBuffer.position(currentPosition);
                ioBuffer.limit(limit);
            }
        }
    }

    @Override
    public void finishDecode(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {

    }

    @Override
    public void dispose(IoSession ioSession) throws Exception {

    }
}
