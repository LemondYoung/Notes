package com.monsterlin.websocket

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

import org.java_websocket.client.WebSocketClient
import org.java_websocket.drafts.Draft_10
import org.java_websocket.handshake.ServerHandshake

import java.net.URI
import java.net.URISyntaxException

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
 * @desc : Socket通讯
 * @tag: https://blog.csdn.net/moxiouhao/article/details/77840168
 * @date : 2018/9/26 8:00 PM
 */
class MainActivity : AppCompatActivity() {


    private var mSocketClient: WebSocketClient? = null

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            main_tv_content!!.text = main_edt_content!!.text.toString() + "\n" + msg.obj
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        Thread(Runnable {
            try {
                mSocketClient = object : WebSocketClient(URI("ws://127.0.0.1"), Draft_10()) {
                    override fun onOpen(handshakedata: ServerHandshake) {
                        Log.d("webSocket", "打开通道" + handshakedata.httpStatus)
                    }

                    override fun onMessage(message: String) {
                        Log.d("webSocket", "接收消息$message")
                        handler.obtainMessage(0, message).sendToTarget()
                    }

                    override fun onClose(code: Int, reason: String, remote: Boolean) {
                        Log.d("webSocket", "通道关闭")
                        handler.obtainMessage(0, reason).sendToTarget()
                    }

                    override fun onError(ex: Exception) {
                        Log.d("webSocket", "链接错误")
                    }
                }
                mSocketClient!!.connect()
            } catch (e: URISyntaxException) {
                e.printStackTrace()
            }
        }).start()

        main_btn_send!!.setOnClickListener {
            if (mSocketClient != null) {
                mSocketClient!!.send(main_edt_content!!.text.toString().trim { it <= ' ' })
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        if (mSocketClient != null) {
            mSocketClient!!.close()
        }
    }
}
