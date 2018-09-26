package com.monsterlin.websocket;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;

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
 * @desc : WebSocketServer
 * @date : 2018/9/26 6:44 PM
 */
public class MWebSocketService extends WebSocketServer {


    public MWebSocketService(InetSocketAddress address) {
        super(address);
    }

    public MWebSocketService(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }


    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        //得到连接的远程主机地址
        String address = webSocket.getRemoteSocketAddress().getAddress().getHostAddress();
        String message = String.format("(%s)<进行房间！>", address);
        sendToAll(message);
        System.out.println(message);
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        String address = webSocket.getRemoteSocketAddress().getAddress().getHostAddress();
        String message = String.format("(%s)<退出房间！>", address);
        sendToAll(message);
        System.out.println(message);
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        //服务端接收消息
        String address = webSocket.getRemoteSocketAddress().getAddress().getHostAddress();
        String message = String.format("(%s) %s", address, s);
        //将消息发送给所有的客户端
        sendToAll(message);
        System.out.println(message);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        if (null != webSocket) {
            webSocket.close(0);
        }
        e.printStackTrace();
    }

    public void sendToAll(String message) {
        //获取所有的连接的客户端
        Collection<WebSocket> connections = connections();

        //将消息发送给每一个客户端
        for (WebSocket client : connections) {
            client.send(message);
        }
    }

}
