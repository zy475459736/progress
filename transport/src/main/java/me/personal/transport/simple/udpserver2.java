package me.personal.transport.simple;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * Created by zhongyi on 2018/7/19.
 */
public class udpserver2 {
    public static void main(String[] args) {
        try {
            byte[] data = new byte[1024];
            DatagramSocket ds = new DatagramSocket(1000);
            while (true) {
                DatagramPacket dp = new DatagramPacket(data, data.length);
                ds.receive(dp);
                int port = dp.getPort();
                String address = dp.getAddress().getHostAddress();
                int length = dp.getLength();
            }

        } catch (Exception e) {

        }
    }
}
