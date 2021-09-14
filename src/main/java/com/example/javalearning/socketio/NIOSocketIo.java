package com.example.javalearning.socketio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 非阻塞 IO 模型
 * Selector，主要负责调度和监控客户端和服务端（调度器）
 * 由阻塞方式改为非阻塞方式（Non-Blocking）
 *
 * @author liugenlai
 * @since 2021/9/7 9:31
 */
@Slf4j
public class NIOSocketIo {
    private Selector selector;

    public static void main(String[] args) {

    }

    /**
     * 初始化服务
     *
     * @throws IOException
     */
    public void initServer() throws IOException {
        // 通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞模式
        socketChannel.configureBlocking(false);
        // 绑定到端口
        socketChannel.bind(new InetSocketAddress(8888));
        // 获取选择器
        selector = Selector.open();
        // 注册到选择器
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        log.info("server is running......");
    }

    /**
     * 轮询监听 Selector
     *
     * @throws IOException
     */
    public void listenSelector() throws IOException {
        // 轮询监听 selector
        while (true) {
            // 最终会调用到操作系统中的多用复用选择器（本地方法）方法（如poll/epoll/select等）
            // 等待客户连接
            this.selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                // 处理请求
                handler(key);
            }
        }
    }

    public void handler(SelectionKey key) throws IOException {
        // 连接事件
        if (key.isAcceptable()) {
            log.info("new client is connected to server......");
            // 处理客户端请求事件
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            // 设置成非阻塞
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            // 读取事件
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(byteBuffer);
            if (read > 0) {
                String info = new String(byteBuffer.array(), "GBK");
                log.info(info);
            }
        }
    }
}
