package com.monsterlin.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
 * @desc : webSocket主要类
 * @date : 2018/9/26 6:58 PM
 */
public class WebSocketMainMethod {

    private static int PORT = 2017;

    public static void main(String[] args) throws IOException {
        //实例化webSocket服务 => 启动服务
        MWebSocketService socketService = new MWebSocketService(PORT);
        socketService.start();

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = socketService.getPort();
            System.out.println(String.format("服务已启动: %s:%d", ip, port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        while (true) {
            try {
                String msg = reader.readLine();
                socketService.sendToAll(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
