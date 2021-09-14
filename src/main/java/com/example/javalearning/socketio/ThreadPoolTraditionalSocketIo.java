package com.example.javalearning.socketio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 传统阻塞 IO 模型线程池版改进型
 *
 * @author liugenlai
 * @since 2021/9/7 9:10
 */
@Slf4j
public class ThreadPoolTraditionalSocketIo {

    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        ServerSocket serverSocket = new ServerSocket(8888);
        log.info("server is running......");

        while (true) {
            final Socket socket = serverSocket.accept();

            // 每连上一个客户端放到线程池中处理任务
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("new client is connected to server......");
                    InputStream inputStream = null;
                    try {
                        inputStream = socket.getInputStream();
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
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
