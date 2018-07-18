package me.personal.tcp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by zhongyi on 2018/7/19.
 */
public class udpclient2 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            DatagramSocket ds = new DatagramSocket();
            InetAddress inet = InetAddress.getByName("192.168.1.101");
            while(true){
                String message = sc.nextLine();
                byte[] bytes = message.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length,inet,1000);
            }
        }catch (Exception e){

        }
    }
}
