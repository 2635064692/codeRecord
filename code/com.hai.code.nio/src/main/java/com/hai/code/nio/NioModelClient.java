package com.hai.code.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author admin_z by 2021/9/7
 * @ClassName NioModelClient
 */
public class NioModelClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
        OutputStream out = socket.getOutputStream();
        String s = "hello world---hello";
        out.write(s.getBytes());
        out.close();
    }
}
