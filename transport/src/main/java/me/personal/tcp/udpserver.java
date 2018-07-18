package me.personal.tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * Created by zhongyi on 2018/7/19.
 */
public class udpserver {
    public static void main(String[] args) {
        //创建DatagramSocket对象,必须绑定端口号DatagramSocket(int port);
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(1000);
            //创建一个字节数组用来接收数据
            byte[] data = new byte[1024];
            //创建一个DatagramPacket数据包对象
            DatagramPacket dp = new DatagramPacket(data,data.length);
            //调用DatagramSocket对象的receive(DatagramPacekt dp)接收数据
            datagramSocket.receive(dp);
            //拆包
	        /*
	            需要知道发送者的IP
		        DatagramPacket中的public InetAddress getAddress()
	            需要发送端的端口号
		        DatagramPacket中的public int getPort()
	            知道数据的字节个数,避免资源浪费
		        DatagramPacket中的public int getLength()
	        */
            int length = dp.getLength();
            int port = dp.getPort();
            String address = dp.getAddress().getHostAddress();
            //关闭资源

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }

    }
}
