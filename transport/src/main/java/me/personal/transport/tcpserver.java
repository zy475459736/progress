package me.personal.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhongyi on 2018/7/19.
 */
public class tcpserver {
//    服务器为了区分到底是那个客户端连接了，需要拿到客户端的套接字
//    public ServiceSocket(int port);
//    public Socket accept();
//    这个套接字对象是通过IO传过来的
//    public InputStream getInpurStream();
//    向客户端回写数据的方法
//    public OutputStream getOutputStream();
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1000);
            Socket socket = server.accept();
            InputStream in = socket.getInputStream();
            byte[] data = new byte[1024];
            int len = in.read(data);
            System.out.println(new String(data, 0, len));
            OutputStream out = socket.getOutputStream();
            out.write(Integer.parseInt("aaa"));
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
