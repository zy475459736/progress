package me.personal.progress.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServer implements Runnable{

    @Override
    public void run() {
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(!Thread.interrupted()){
                new Thread(new Handler(serverSocket.accept())).start();
            }
        }catch (IOException e){System.out.println("IOException handled."+e.toString());}
    }

    static class Handler implements Runnable{
        final Socket socket ;
        Handler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            byte[] input = new byte[MAX_INPUT];
            try {
                Thread thread;
                socket.getInputStream().read(input);//read
                byte[] output = process(input);//业务逻辑
                socket.getOutputStream().write(output);//write
                socket.getOutputStream().flush();
                socket.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //打印然后return字符串
        byte[] process(byte[] read){
            String result = "The result is: \n " + new String(read);
            System.out.println(result);
            return result.getBytes();
        }
    }


    BasicServer(){
        System.out.println("Basic Server started successfully.");
    }

    public static void main(String[] args) {
        new Thread(new BasicServer())
                .start();
    }
    private static final int PORT = 8082;
    private static final int MAX_INPUT =1024;
    private static volatile int num = 0;

}

