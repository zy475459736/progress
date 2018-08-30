package me.personal.progress.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServer implements Runnable{

    private static final int PORT = 8082;
    private static volatile int num = 0;

    public static void main(String[] args) {
        new Thread(new BasicServer())
                .start();
    }

    BasicServer(){
        System.out.println("Basic Server started successfully.");
    }

    @Override
    public void run() {
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(!Thread.interrupted()){
                new Thread(new Handler(serverSocket.accept()))
                        .start();
            }
        }catch (IOException e){
            System.out.println("IOException handled."+e.toString());
        }
    }



    static class Handler implements Runnable{

        final Socket socket ;
        Handler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            byte[] input = new byte[1024];

            try {
                socket.getInputStream().read(input);
                byte[] output = process(input);

                socket.getOutputStream().write(output);

                socket.getOutputStream().flush();
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

}

