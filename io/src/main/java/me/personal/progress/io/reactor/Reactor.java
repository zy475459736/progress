package me.personal.progress.io.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zhongyi on 2018/8/30.
 */
public class Reactor implements Runnable {

    final Selector selector;
    final ServerSocketChannel serverSocketChannel;

    Reactor(Selector selector, ServerSocketChannel serverSocketChannel) {
        this.selector = selector;
        this.serverSocketChannel = serverSocketChannel;
    }

    Reactor(int port) throws Exception {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            System.out.println("into run method");
            while (!Thread.interrupted()) {
                selector.select();
                Set sets = selector.selectedKeys();
                Iterator<SelectionKey> iterator = sets.iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        System.out.println("into dispatch method:" + selectionKey.toString());
        Runnable runnable = (Runnable) selectionKey.attachment();
        if (runnable != null) {
            new Thread(runnable).start();
        }
    }

    final class Acceptor implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    new Handler(selector, socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    final class Handler implements Runnable {

        final SocketChannel socketChannel;
        final SelectionKey selectionKey;
        ByteBuffer input = ByteBuffer.allocate(1024);
        ByteBuffer output = ByteBuffer.allocate(1024);
        static final int READING = 0, SENDING = 1;
        int state = READING;

        Handler(Selector selector, SocketChannel socketChannel) throws IOException {
            this.socketChannel = socketChannel;
            socketChannel.configureBlocking(false);
            selectionKey = socketChannel.register(selector, 0);
            selectionKey.attach(this);
            selectionKey.interestOps(SelectionKey.OP_READ);
            selector.wakeup();
        }

        boolean inputIsComplete() {
            return true;
        }

        boolean outputIsComplete() {
            return true;
        }

        void process() {
            System.out.println("processing");
        }

        @Override
        public void run() {
            System.out.println("into handler run method");
            try {
                if (state == READING) {
                    read();
                }
                if (state == SENDING) {
                    send();
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

        void read() throws IOException {
            socketChannel.read(input);
            if (inputIsComplete()) {
                process();
                state = SENDING;
                selectionKey.interestOps(SelectionKey.OP_WRITE);
            }
        }

        void send() throws IOException {
            socketChannel.write(output);
            if (outputIsComplete()) {
                selectionKey.cancel();
            }
        }
    }

}

