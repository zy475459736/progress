package me.personal.transport.simple;

import java.io.IOException;
import java.net.*;

/**
 * udp客户端
 * Created by zhongyi on 2018/7/18.
 *
 * ​   DategramPacket是UDP对传输数据对象的封装，接受端的IP，端口号的封装
 *    DatagramSocket是对封装好的数据包的传输对象,是绑定IP和端口号的套接字
 *
IP地址和端口号
 ​ 用来区分计算机的唯一标识（IP地址）
 ● 手动写的
 ● 分配的
 计算机之间的数据通讯
 端口：通讯是为了避免不同程序之间的数据发错，导致丢失等等，操作系统实现的逻辑编号，每个应用程序都有被分配的端口号。
 UDP协议
 ​ UDP是无连接通信协议，既在传输数据时。数据的发送端和接受端不建立逻辑连接，不确认接受端是否存在，也不会接受反馈。
 ● UDP协议消耗资源小，通信效率高，一般用于音频，视频和普通护具的传输
 ● 使用UDP不能确保数据的完整，可能会丢失
 ● 数据大小被限制在64K内

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
