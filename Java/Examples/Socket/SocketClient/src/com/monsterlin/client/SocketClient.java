package com.monsterlin.client;

import java.io.*;
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
 * @desc : Socket客户端
 * @date : 2018/9/25 7:01 PM
 */
public class SocketClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.start();
    }

    public void start() {
        BufferedReader inputReader = null;  //从控制台接收数据
        BufferedReader reader = null; //通过socket接收数据
        BufferedWriter writer = null; //通过socket发送数据
        Socket socket = null; //一条长连接

        try {
            socket = new Socket("127.0.0.1", 9898);

            //相对自身而言：去接收数据，对于客户端是输入流
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //相对自身而言： 去发送数据 对于客户端是输出流
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //从控制台接收数据
            inputReader = new BufferedReader(new InputStreamReader(System.in));

            //监听器去监听服务器返回的数据
            startServerReplyListener(reader);

            String inputContent;
            while (!(inputContent = inputReader.readLine()).equals("bye")) {
                writer.write(inputContent + "\n");
                writer.flush();

//                String response = reader.readLine();
//                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
                inputReader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void startServerReplyListener(final BufferedReader reader){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String response ;
                    while ((response=reader.readLine())!=null){
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
