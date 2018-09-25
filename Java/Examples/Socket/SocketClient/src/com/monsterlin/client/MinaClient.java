package com.monsterlin.client;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * @desc : Mina客户端
 * @date : 2018/9/26 12:00 AM
 */
public class MinaClient {
    public static void main(String[] args) throws IOException {
        NioSocketConnector connector = new NioSocketConnector();
        connector.setHandler(new MyClientrHandler());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 9898));

        //阻塞住，等待连接
        future.awaitUninterruptibly();
        IoSession session = future.getSession();
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent;
        while (!(inputContent = inputReader.readLine()).equals("bye")) {
            session.write(inputContent);
        }
    }
}
