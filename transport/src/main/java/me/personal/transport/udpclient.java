package me.personal.transport;

import java.io.IOException;
import java.net.*;

/**
 * udp客户端
 * Created by zhongyi on 2018/7/18.
 *
 * ​   DategramPacket是UDP对传输数据对象的封装，接受端的IP，端口号的封装
 *    DatagramSocket是对封装好的数据包的传输对象,是绑定IP和端口号的套接字
 * public static InetAddress getLocalHost()
 * localhost本地主机，会抛出异常
 * 主机名和IP地址
 * public String getHostName()
 * public String getHostAddress()
 * 传输别人的主机名，拿到对方的IP地址
 * public static InetAddress getByName(String name)
 *
 */
public class udpclient {

    public static void main(String[] args) {
        //创建DatagramPacket对象
        //DatagramPacket(byte[] buf,int length,InetAddress address,int port);
        byte[] data = "你好UDP".getBytes();
        InetAddress inet = null;
        try {
            inet = InetAddress.getByName("192.168.1.101");

            //封装数据对象
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inet, 10001);
            //创建Socket对象
            DatagramSocket datagramSocket = new DatagramSocket();
            //发送数据包
            datagramSocket.send(datagramPacket);
            //关闭资源
            datagramSocket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
