package com.monsterlin.server;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

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
 * @desc : MiNa服务
 * @date : 2018/9/25 10:42 PM
 */
public class MinaServer {
    public static void main(String[] args) {
        try {
            NioSocketAcceptor acceptor = new NioSocketAcceptor();
            acceptor.setHandler(new MyServerHandler());

            //TextLineCodecFactory -> 解码单行的数据
            //acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory()));

            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyTextLineFactory()));

            //检测客户端和服务器是否掉线，空闲状态的配置，在5s内服务端没有向客户端发生读写的时候
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 5);
            acceptor.bind(new InetSocketAddress(9898));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
