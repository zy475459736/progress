package me.personal.transport.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * TCP协议是面向连接呃通信协议。必须建立发送与接收端的逻辑连接。
    ● 客户端想服务端发出连接请求
    ● 服务端向客户端发送一个响应
    ● 客服端想服务端发送确认信息
    ● 刻意确保传输数据的安全性
    ​==TCP与UDP的区分：==UDP只区分发送和接受，但是TCP严格区分客服端和服务器，服务器不会主动连接客户端。在连接通路完成后悔自动建立一个字节流对象（OutputStream，InputStream）
 * Created by zhongyi on 2018/7/19.
 */
public class tcpclient {
//    传入服务器的IP和端口号，一运行就会去连接
//    public Socket(String host,int port);
//    一但连接就会创建对应的输入输出流
//    public OutputStream getOutputStream();
//
//    public InputStream getInputStream();
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",1000);
            OutputStream out = socket.getOutputStream();
            out.write(Integer.parseInt("s"));
            //网络上的流对象可以不用关闭流对象
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
