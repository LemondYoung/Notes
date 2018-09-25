package com.monsterlin.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
 * @desc : Socket服务端
 * @date : 2018/9/25 7:13 PM
 */
public class SocketServer {

    BufferedReader reader = null;   //通过socket去接收数据
    BufferedWriter writer = null;  //通过socket去发送数据

    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.startServer();
    }

    public void startServer() {
        ServerSocket serverSocket = null;
        Socket socket = null; //一条长连接

        try {
            serverSocket = new ServerSocket(9898);
            System.out.println("server started..");
            while (true) {
                socket = serverSocket.accept();  //服务器进入阻塞状态，等待客户端接入
                manageConnection(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void manageConnection(final Socket socket) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("client " + socket.hashCode() + " connected");
                    //相对自身而言，去接收数据，对于服务端来说是输入流
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //相对自身而言，去发送数据，对服务端而言是输出流
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String receivedMsg;
                    while ((receivedMsg = reader.readLine()) != null) {
                        System.out.println("client " + socket.hashCode() + ": " + receivedMsg);
                        writer.write("server reply: " + receivedMsg + "\n");
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        reader.close();
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
