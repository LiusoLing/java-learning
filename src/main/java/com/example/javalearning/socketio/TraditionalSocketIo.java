package com.example.javalearning.socketio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统的 阻塞模式IO
 *
 * @author liugenlai
 * @since 2021/9/7 8:55
 */
@Slf4j
public class TraditionalSocketIo {

    /**
     * 服务端同一时间只能处理一个客户端的任务，其他客户端的任务
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        log.info("server is running......");

        while (true) {
            Socket socket = serverSocket.accept();
            log.info("new client is connected to server......");
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while (true) {
                int read = inputStream.read(bytes);
                if (read > 0) {
                    String info = new String(bytes, 0, read, "GBK");
                    log.info(info);
                } else {
                    break;
                }
            }
        }
    }
}
